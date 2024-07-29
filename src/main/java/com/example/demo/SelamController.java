package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SelamController {

    @GetMapping("/selam")
    public String selam(@RequestParam(name="name") String name,@RequestParam(name="surname") String surname, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        return "selam";
    }

}