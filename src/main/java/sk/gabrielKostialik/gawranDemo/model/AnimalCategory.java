package sk.gabrielKostialik.gawranDemo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AnimalCategory  {
    @Id
    String name;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "animalCategory")
    private Set<Product> products = new HashSet<>();

    public AnimalCategory(String name) {
        this.name = name;
    }

    public AnimalCategory() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
