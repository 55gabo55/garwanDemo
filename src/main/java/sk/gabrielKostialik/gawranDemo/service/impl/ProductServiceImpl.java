package sk.gabrielKostialik.gawranDemo.service.impl;

import org.springframework.stereotype.Service;
import sk.gabrielKostialik.gawranDemo.mapper.ProductMapper;
import sk.gabrielKostialik.gawranDemo.model.Product;
import sk.gabrielKostialik.gawranDemo.model.dto.ProductDto;
import sk.gabrielKostialik.gawranDemo.repository.ProductRepository;
import sk.gabrielKostialik.gawranDemo.service.api.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper.INSTANCE::productToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProduct(long id) {
        Product product = productRepository.findById(id).orElse(null);

        if (product != null) {
            return ProductMapper.INSTANCE.productToDto(product);
        } else {
            return null;
        }
    }
}
