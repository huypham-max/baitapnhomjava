package com.example.genderhealthcare.controller;

import com.example.genderhealthcare.entity.*;
import com.example.genderhealthcare.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ConsultantRepository consultantRepo;

    @PostMapping("/ask")
    public ResponseEntity<?> ask(@RequestParam String content, @RequestParam Long consultantId, Principal principal) {
        User user = userRepo.findByUsername(principal.getName());
        Consultant consultant = consultantRepo.findById(consultantId).orElseThrow();

        Question question = new Question();
        question.setContent(content);
        question.setCustomer(user);
        question.setConsultant(consultant);
        question.setCreatedAt(LocalDateTime.now());

        questionRepo.save(question);
        return ResponseEntity.ok("Đã gửi câu hỏi.");
    }

    @PostMapping("/answer/{id}")
    public ResponseEntity<?> answer(@PathVariable Long id, @RequestParam String answer) {
        Question question = questionRepo.findById(id).orElseThrow();
        question.setAnswer(answer);
        question.setAnsweredAt(LocalDateTime.now());
        questionRepo.save(question);
        return ResponseEntity.ok("Đã trả lời.");
    }

    @GetMapping("/my")
    public List<Question> getMyQuestions(Principal principal) {
        User user = userRepo.findByUsername(principal.getName());
        return questionRepo.findByCustomer(user);
    }
}
