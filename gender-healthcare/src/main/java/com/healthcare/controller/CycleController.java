package com.healthcare.controller;

import com.healthcare.entity.Cycle;
import com.healthcare.repository.CycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CycleController {

    @Autowired
    private CycleRepository cycleRepository;

    @GetMapping("/cycle")
    public String showForm(Model model) {
        model.addAttribute("cycle", new Cycle());
        return "cycle_form";
    }

    @PostMapping("/cycle")
    public String submitForm(@ModelAttribute Cycle cycle, Model model) {
        cycle.calculateFertilityWindow();
        cycleRepository.save(cycle);
        model.addAttribute("cycle", cycle);
        return "cycle_result";
    }
}
