package sk.gabrielKostialik.gawranDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.gabrielKostialik.gawranDemo.model.AnimalCategory;
import sk.gabrielKostialik.gawranDemo.model.dto.AnimalCategoryDto;
import sk.gabrielKostialik.gawranDemo.service.api.AnimalCategoryService;

import java.util.List;

@RestController
public class AnimalCategoryController {

    AnimalCategoryService animalCategoryService;

    public AnimalCategoryController(AnimalCategoryService animalCategoryService) {
        this.animalCategoryService = animalCategoryService;
    }

    @GetMapping("/animalCategory")
    public List<AnimalCategoryDto> getAnimalCategory() {
        return animalCategoryService.getAll();
    }
}
