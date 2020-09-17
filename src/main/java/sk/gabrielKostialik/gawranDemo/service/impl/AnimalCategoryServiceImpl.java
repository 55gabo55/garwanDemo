package sk.gabrielKostialik.gawranDemo.service.impl;

import org.springframework.stereotype.Service;
import sk.gabrielKostialik.gawranDemo.mapper.AnimalCategoryMapper;
import sk.gabrielKostialik.gawranDemo.mapper.ProductMapper;
import sk.gabrielKostialik.gawranDemo.model.AnimalCategory;
import sk.gabrielKostialik.gawranDemo.model.dto.AnimalCategoryDto;
import sk.gabrielKostialik.gawranDemo.repository.AnimalCategoryRepository;
import sk.gabrielKostialik.gawranDemo.service.api.AnimalCategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalCategoryServiceImpl implements AnimalCategoryService {

    AnimalCategoryRepository animalCategoryRepository;

    public AnimalCategoryServiceImpl(AnimalCategoryRepository animalCategoryRepository) {
        this.animalCategoryRepository = animalCategoryRepository;
    }

    @Override
    public void addAnimalCategory(AnimalCategory animalCategory) {
        animalCategoryRepository.save(animalCategory);
    }

    @Override
    public AnimalCategory getAnimalCategory(String name) {
        return animalCategoryRepository.findByName(name);
    }

    @Override
    public List<AnimalCategoryDto> getAll() {
        return animalCategoryRepository.findAll().stream()
                .map(AnimalCategoryMapper.INSTANCE::animalCategoryToDto)
                .collect(Collectors.toList());
    }
}
