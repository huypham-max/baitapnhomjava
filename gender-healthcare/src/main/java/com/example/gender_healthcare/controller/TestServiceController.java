package com.example.genderhealthcare.controller;

import com.example.genderhealthcare.model.TestService;
import com.example.genderhealthcare.service.TestServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/services")
public class TestServiceController {
  private final TestServiceService svc;
  public TestServiceController(TestServiceService svc){ this.svc = svc; }

  @GetMapping
  public String list(Model m){
    m.addAttribute("services", svc.findAll());
    return "service/list";
  }

  @GetMapping("/add")
  public String form(Model m){
    m.addAttribute("service", new TestService());
    return "service/form";
  }

  @PostMapping("/save")
  public String save(@ModelAttribute TestService s){
    svc.save(s);
    return "redirect:/services";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id){
    svc.delete(id);
    return "redirect:/services";
  }
}
