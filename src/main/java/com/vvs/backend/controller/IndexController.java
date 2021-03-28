package com.vvs.backend.controller;

import java.util.ArrayList;

import com.vvs.backend.model.Goods;
import com.vvs.backend.model.User;
import com.vvs.backend.repository.GoodsRepository;
import com.vvs.backend.service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsRepository goodsRepository;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());

        if (goodsRepository.findAll().size() == 0) {
            ArrayList<Goods> goods =  goodsService.importGoodsFromJson();
            for (Goods good : goods) {
                goodsRepository.save(good);
            }
        }
        return "index";
    }
}
