package com.laineros.trainingRestAPI.controller;

import com.laineros.trainingRestAPI.DTO.CatDTO;
import com.laineros.trainingRestAPI.entity.Cat;
import com.laineros.trainingRestAPI.repository.CatRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "mainMethods")
@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final CatRepo catRepo;
    @Operation(
            summary = "Добавляет нового китика в базу",
            description = "Получает DTO кота, собирает с помощью билдера и сохраняет сущность в базу"
    )
    @PostMapping("/api/add")
    public void addCat(@RequestBody CatDTO catDTO) {
        log.info("New row -> " +
                catRepo.save(Cat.builder()
                        .age(catDTO.getAge())
                        .weight(catDTO.getWeight())
                        .name(catDTO.getName())
                        .build()));
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
