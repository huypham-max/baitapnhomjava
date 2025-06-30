package com.healthcare.controller;

import com.healthcare.entity.Appointment;
import com.healthcare.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/appointment")
    public String showForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "appointment_form";
    }

    @PostMapping("/appointment")
    public String submitForm(@ModelAttribute Appointment appointment, Model model) {
        appointmentRepository.save(appointment);
        model.addAttribute("appointment", appointment);
        return "appointment_result";
    }
}
