package sk.gabrielKostialik.gawranDemo.service.api;

import sk.gabrielKostialik.gawranDemo.model.ShopOrder;
import sk.gabrielKostialik.gawranDemo.model.dto.ShopOrderDto;

public interface ShopOrderService {
   ShopOrderDto getOrderDto();
   ShopOrder getOrder();
   void addOrder();
   void saveOrder(ShopOrder shopOrder);
}
