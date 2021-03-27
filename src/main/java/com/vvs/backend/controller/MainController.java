package com.vvs.backend.controller;

import com.vvs.backend.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.java.Log;

@Log
@Controller
@CrossOrigin(origins = "localhost:8080")
public class MainController {
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/buy")
    public String buyGoods(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        log.info(user.toString());
        return "index";
    }
}
