package com.example.demo.controller;

import com.example.demo.repository.UserRepository;
import com.example.demo.security.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfo userInfo;

    @GetMapping
    public String getProfile(Model model) {
        model.addAttribute("profile", userRepository.findByEmail(userInfo.getEmail()));
        return "profile";
    }
}
