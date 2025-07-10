package com.healthcare.controller;

import com.healthcare.entity.Question;
import com.healthcare.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class QuestionPageController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/question")
    public String showQuestionPage(Model model) {
        List<Question> questions = questionRepository.findAll();
        model.addAttribute("questions", questions); // đúng tên
        return "ask-question"; // đúng tên file html
    }

    @PostMapping("/question")
    public String submitQuestion(@RequestParam("content") String content) {
        Question q = new Question();
        q.setContent(content);
        q.setCreatedAt(LocalDateTime.now());
        questionRepository.save(q);

        return "redirect:/questions";
    }
}
