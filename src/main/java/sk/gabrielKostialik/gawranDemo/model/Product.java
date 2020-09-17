package sk.gabrielKostialik.gawranDemo.model;

import sk.gabrielKostialik.gawranDemo.model.enumModel.AnimalCategory2;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products", nullable = false)
    private AnimalCategory animalCategory;


    private int price;
    private String description;
    private ArrayList<String> gallery;

    public Product() {
    }

    public Product(String name, AnimalCategory animalCategory, int price, String description, ArrayList<String> gallery) {
        this.name = name;
        this.animalCategory = animalCategory;
        this.price = price;
        this.description = description;
        this.gallery = gallery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalCategory getAnimalCategory() {
        return animalCategory;
    }

    public void setAnimalCategory(AnimalCategory animalCategory) {
        this.animalCategory = animalCategory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getGallery() {
        return gallery;
    }

    public void setGallery(ArrayList<String> gallery) {
        this.gallery = gallery;
    }
}
