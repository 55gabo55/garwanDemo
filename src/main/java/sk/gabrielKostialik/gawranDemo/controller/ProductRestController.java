package sk.gabrielKostialik.gawranDemo.controller;

import org.springframework.web.bind.annotation.*;
import sk.gabrielKostialik.gawranDemo.model.Product;
import sk.gabrielKostialik.gawranDemo.model.dto.ProductDto;
import sk.gabrielKostialik.gawranDemo.service.api.ProductService;

import java.util.List;

@RestController
public class ProductRestController {

    ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/products/{id}")
    public ProductDto getProduct(@PathVariable("id") long id) {
        return productService.getProduct(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
}
