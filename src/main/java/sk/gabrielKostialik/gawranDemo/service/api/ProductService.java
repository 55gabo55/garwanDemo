package sk.gabrielKostialik.gawranDemo.service.api;

import sk.gabrielKostialik.gawranDemo.model.Product;
import sk.gabrielKostialik.gawranDemo.model.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    List<ProductDto> getAll();
    ProductDto getProduct(long id);
}
