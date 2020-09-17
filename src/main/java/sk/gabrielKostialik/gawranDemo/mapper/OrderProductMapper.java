package sk.gabrielKostialik.gawranDemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sk.gabrielKostialik.gawranDemo.model.OrderProduct;
import sk.gabrielKostialik.gawranDemo.model.dto.OrderProductDto;


@Mapper
public interface OrderProductMapper {
    OrderProductMapper INSTANCE = Mappers.getMapper(OrderProductMapper.class);

    OrderProductDto productToDto(OrderProduct orderProduct);
    OrderProduct dtoToProduct(OrderProductDto orderProductDto);
}