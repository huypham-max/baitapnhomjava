package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthcare.entity.User;
import com.healthcare.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Trang đăng ký
    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    // Xử lý đăng ký
    @PostMapping("/signup")
    public String processSignup(@ModelAttribute("user") User user, Model model) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại!");
            return "signup";
        }
        userRepository.save(user);
        model.addAttribute("message", "Đăng ký thành công!");
        return "login";
    }

    // Trang đăng nhập
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Xử lý đăng nhập
    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("username", user.getUsername());
            return "dashboard";
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
            return "login";
        }
    }

    // Trang dashboard người dùng
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Bạn có thể truyền thêm thông tin người dùng nếu cần
        return "dashboard";
    }
}
