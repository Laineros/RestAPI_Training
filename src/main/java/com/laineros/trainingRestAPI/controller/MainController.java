package com.laineros.trainingRestAPI.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laineros.trainingRestAPI.entity.Cat;
import com.laineros.trainingRestAPI.repository.CatRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final CatRepo catRepo;
    private final ObjectMapper objectMapper;

    @PostMapping("/api/add")
    public void addCat(@RequestBody Cat cat) {
        log.info("New row -> " + catRepo.save(cat));
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public String getAllCats() {
        List<Cat> cats = catRepo.findAll();
        return objectMapper.writeValueAsString(cats);
    }
}
