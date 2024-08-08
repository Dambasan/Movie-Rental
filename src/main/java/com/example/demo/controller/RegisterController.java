package com.example.demo.controller;

import com.example.demo.models.RegisterForm;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
@Valid
@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("form", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute @Valid RegisterForm form, BindingResult bindingResult, Model model) {
        userService.createUser(form);
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getAllErrors().get(0));
            System.out.println(model);
            return "register";
        }
        return "redirect:/login";
    }

}
