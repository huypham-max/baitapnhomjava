package com.healthcare.controller;

import com.healthcare.entity.User;
import com.healthcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignUp(@ModelAttribute User user, Model model) {
        // TODO: mã hóa mật khẩu nếu cần
        userRepository.save(user);
        model.addAttribute("message", "Đăng ký thành công!");
        return "login"; // chuyển đến form đăng nhập
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
