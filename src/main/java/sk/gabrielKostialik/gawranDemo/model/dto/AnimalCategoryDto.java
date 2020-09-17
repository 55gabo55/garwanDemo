package sk.gabrielKostialik.gawranDemo.model.dto;

public class AnimalCategoryDto {
    String name;

    public AnimalCategoryDto() {
    }

    public AnimalCategoryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
