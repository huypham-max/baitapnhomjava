package com.example.genderhealthcare.controller;

import com.example.genderhealthcare.service.TestRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatsController {
  private final TestRequestService svc;
  public StatsController(TestRequestService svc) { this.svc = svc; }

  @GetMapping("/stats")
  public String stats(Model m) {
    m.addAttribute("total", svc.count());
    m.addAttribute("byPending", svc.countByStatus(TestRequest.Status.PENDING));
    m.addAttribute("reminders", svc.remindTomorrow());
    return "stats";
  }
}
