package com.healthcare.controller;

import com.healthcare.entity.Consultant;
import com.healthcare.entity.Question;
import com.healthcare.entity.User;
import com.healthcare.repository.ConsultantRepository;
import com.healthcare.repository.QuestionRepository;
import com.healthcare.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ConsultantRepository consultantRepo;

    /**
     * Người dùng gửi câu hỏi cho tư vấn viên
     */
    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestParam String content,
                                              @RequestParam Long consultantId,
                                              Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(401).body("Chưa đăng nhập");
        }

        User user = userRepo.findByUsername(principal.getName());
        if (user == null) {
            return ResponseEntity.badRequest().body("Không tìm thấy người dùng");
        }

        Consultant consultant = consultantRepo.findById(consultantId)
                .orElse(null);
        if (consultant == null) {
            return ResponseEntity.badRequest().body("Không tìm thấy tư vấn viên");
        }

        Question question = new Question();
        question.setContent(content);
        question.setCustomer(user);
        question.setConsultant(consultant);
        question.setCreatedAt(LocalDateTime.now());

        questionRepo.save(question);

        return ResponseEntity.ok("Đã gửi câu hỏi thành công.");
    }

    /**
     * Tư vấn viên trả lời câu hỏi
     */
    @PostMapping("/answer/{id}")
    public ResponseEntity<String> answerQuestion(@PathVariable Long id,
                                                 @RequestParam String answer) {
        Question question = questionRepo.findById(id)
                .orElse(null);
        if (question == null) {
            return ResponseEntity.badRequest().body("Không tìm thấy câu hỏi");
        }

        question.setAnswer(answer);
        question.setAnsweredAt(LocalDateTime.now());
        questionRepo.save(question);

        return ResponseEntity.ok("Đã trả lời câu hỏi.");
    }

    /**
     * Người dùng xem câu hỏi của chính họ
     */
    @GetMapping("/my")
    public ResponseEntity<List<Question>> getMyQuestions(Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(401).build();
        }

        User user = userRepo.findByUsername(principal.getName());
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        List<Question> questions = questionRepo.findByCustomer(user);
        return ResponseEntity.ok(questions);
    }
    
}
