package sk.gabrielKostialik.gawranDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sk.gabrielKostialik.gawranDemo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
