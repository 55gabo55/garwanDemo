package sk.gabrielKostialik.gawranDemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sk.gabrielKostialik.gawranDemo.model.AnimalCategory;
import sk.gabrielKostialik.gawranDemo.model.dto.AnimalCategoryDto;

@Mapper
public interface AnimalCategoryMapper {
    AnimalCategoryMapper INSTANCE = Mappers.getMapper(AnimalCategoryMapper.class);

    AnimalCategoryDto animalCategoryToDto(AnimalCategory animalCategory);
    AnimalCategory dtoToAnimalCategory(AnimalCategoryDto animalCategoryDto);
}
