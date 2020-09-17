package sk.gabrielKostialik.gawranDemo.service.api;

import sk.gabrielKostialik.gawranDemo.model.AnimalCategory;
import sk.gabrielKostialik.gawranDemo.model.dto.AnimalCategoryDto;

import java.util.List;

public interface AnimalCategoryService {
    void addAnimalCategory(AnimalCategory animalCategory);
    AnimalCategory getAnimalCategory(String name);
    List<AnimalCategoryDto> getAll();
}
