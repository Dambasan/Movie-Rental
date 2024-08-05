package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/{id}")
    public String getActor(Model model, @PathVariable(value = "id", required = false) Long id) {
        model.addAttribute("actor", actorService.getActorById(id));
        model.addAttribute("movies", actorService.getMovieByActorId(id));
            return "actor";
    }
}
