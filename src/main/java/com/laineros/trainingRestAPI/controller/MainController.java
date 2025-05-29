package com.laineros.trainingRestAPI.controller;

import com.laineros.trainingRestAPI.entity.Cat;
import com.laineros.trainingRestAPI.repository.CatRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final CatRepo catRepo;

    @PostMapping("/api/add")
    public void addCat(@RequestBody Cat cat) {
        log.info("New row -> " + catRepo.save(cat));
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public List<Cat> getAllCats() {
        return catRepo.findAll();
    }

    @GetMapping("/api")
    public Cat getCat(@RequestParam int id) {
        return catRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/api")
    public void deleteCat(@RequestParam int id) {
        catRepo.deleteById(id);
    }
    @PutMapping("/api/add")
    public String updateCat(@RequestBody Cat cat) {
        if (!catRepo.existsById(cat.getId())) {
            return "Not found";
        }
        return catRepo.save(cat).toString();
    }
}
