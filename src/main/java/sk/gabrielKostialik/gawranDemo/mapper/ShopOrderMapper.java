package sk.gabrielKostialik.gawranDemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sk.gabrielKostialik.gawranDemo.model.OrderProduct;
import sk.gabrielKostialik.gawranDemo.model.ShopOrder;
import sk.gabrielKostialik.gawranDemo.model.dto.OrderProductDto;
import sk.gabrielKostialik.gawranDemo.model.dto.ShopOrderDto;


@Mapper
public interface ShopOrderMapper {
    ShopOrderMapper INSTANCE = Mappers.getMapper(ShopOrderMapper.class);

    ShopOrderDto shopOrderToDto(ShopOrder shopOrder);
    ShopOrder dtoToShopOrder(ShopOrderDto shopOrderDto);
}