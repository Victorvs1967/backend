package com.vvs.backend.controller;

import java.util.List;

import com.vvs.backend.model.Goods;
import com.vvs.backend.model.User;
import com.vvs.backend.repository.GoodsRepository;
import com.vvs.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "localhost:8080")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GoodsRepository goodsRepository;
    
    @PostMapping("/buy")
    public void buyGoods(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        userRepository.save(user);
    }

    @GetMapping("/users")
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/goods")
    public List<Goods> allGoods() {
        return goodsRepository.findAll();
    }
}
