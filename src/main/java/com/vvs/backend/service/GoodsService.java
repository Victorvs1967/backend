package com.vvs.backend.service;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vvs.backend.model.Goods;
import com.vvs.backend.repository.GoodsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Log
@Service
public class GoodsService {
    
    @Autowired
    GoodsRepository goodsRepository;
    
    public ArrayList<Goods> importGoodsFromJson() {
        
        Gson gson = new Gson();
        Type goodsListType = new TypeToken<ArrayList<Goods>>(){}.getType();
        try {
            return gson.fromJson(new FileReader("backend/src/main/resources/static/db/db.json"), goodsListType);
        } catch (IOException e) {
            log.warning(e.getMessage());
        }
        return new ArrayList<>();
    }
}
