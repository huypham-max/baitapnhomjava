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

    // 1. Hiển thị form khai báo chu kỳ (hiện tại cũng dùng để "Xem chu kỳ")
    @GetMapping("/cycle")
    public String showForm(Model model) {
        model.addAttribute("cycle", new Cycle());
        return "cycle_form";
    }

    // 2. Lưu dữ liệu chu kỳ và hiển thị kết quả
    @PostMapping("/cycle")
    public String submitForm(@ModelAttribute Cycle cycle, Model model) {
        cycle.calculateFertilityWindow(); // tính toán rụng trứng (nếu có)
        cycleRepository.save(cycle); // lưu vào DB
        model.addAttribute("cycle", cycle);
        return "cycle_result";
    }
}
