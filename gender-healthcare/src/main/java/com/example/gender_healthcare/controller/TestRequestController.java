package com.example.genderhealthcare.controller;

import com.example.genderhealthcare.model.TestRequest;
import com.example.genderhealthcare.model.TestService;
import com.example.genderhealthcare.service.TestRequestService;
import com.example.genderhealthcare.service.TestServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/requests")
public class TestRequestController {
  private final TestRequestService reqSvc;
  private final TestServiceService svcSvc;
  public TestRequestController(TestRequestService r, TestServiceService s){
    this.reqSvc = r; this.svcSvc = s;
  }

  @GetMapping
  public String list(Model m){
    m.addAttribute("requests", reqSvc.findAll());
    return "request/list";
  }

  @GetMapping("/add")
  public String form(Model m){
    m.addAttribute("request", new TestRequest());
    m.addAttribute("services", svcSvc.findAll());
    return "request/form-schedule";
  }

  @PostMapping("/save")
  public String save(@ModelAttribute TestRequest r){
    r.setDateTime(LocalDateTime.now().plusDays(1));
    reqSvc.save(r);
    return "redirect:/requests";
  }

  // edit status
  @GetMapping("/status/{id}")
  public String statusForm(@PathVariable Long id, Model m){
    m.addAttribute("request", reqSvc.findAll().stream().filter(r->r.getId().equals(id)).findFirst().orElse(null));
    return "request/form-status";
  }
  @PostMapping("/status")
  public String saveStatus(@ModelAttribute TestRequest r){
    reqSvc.save(r);
    return "redirect:/requests";
  }

  // edit result
  @GetMapping("/result/{id}")
  public String resultForm(@PathVariable Long id, Model m){
    m.addAttribute("request", reqSvc.findAll().stream().filter(r->r.getId().equals(id)).findFirst().orElse(null));
    return "request/form-result";
  }
  @PostMapping("/result")
  public String saveResult(@ModelAttribute TestRequest r){
    reqSvc.save(r);
    return "redirect:/requests";
  }
}
