package com.laineros.trainingRestAPI.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laineros.trainingRestAPI.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/api/main")
    public String mainListener() {
        return "Whassup";
    }

    @GetMapping("api/cat")
    public String getCat() {
        Cat cat = new Cat("Murzik", 3, 8);
        String json = null;
        try {
            json = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            System.out.println("Error with cat");
        }
        return json;
    }

    @PostMapping("api/special")
    public String postSpecialCat(@RequestParam String name) {
        Cat cat = new Cat(name, 3, 8);
        String json = null;
        try {
            json = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            System.out.println("Error with cat");
        }
        return json;
    }

}
