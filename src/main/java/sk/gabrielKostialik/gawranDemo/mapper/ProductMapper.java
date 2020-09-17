package sk.gabrielKostialik.gawranDemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sk.gabrielKostialik.gawranDemo.model.Product;
import sk.gabrielKostialik.gawranDemo.model.dto.ProductDto;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto productToDto(Product product);
    Product dtoToProduct(ProductDto productDto);
}
