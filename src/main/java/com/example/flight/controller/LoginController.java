package com.example.flight.controller;

import com.example.flight.entity.User;
import com.example.flight.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          Model model) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            return "redirect:/selectPorts";
        } else {
            model.addAttribute("error", "Kullanıcı adı veya şifre yanlış!");
            return "login";
        }
    }
}
