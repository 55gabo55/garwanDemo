package sk.gabrielKostialik.gawranDemo.service.impl;


import org.springframework.stereotype.Service;
import sk.gabrielKostialik.gawranDemo.mapper.ShopOrderMapper;
import sk.gabrielKostialik.gawranDemo.model.OrderProduct;
import sk.gabrielKostialik.gawranDemo.model.ShopOrder;
import sk.gabrielKostialik.gawranDemo.model.dto.ShopOrderDto;
import sk.gabrielKostialik.gawranDemo.repository.OrderProductRepository;
import sk.gabrielKostialik.gawranDemo.repository.ShopOrderRepository;
import sk.gabrielKostialik.gawranDemo.service.api.ShopOrderService;

import java.time.LocalTime;
import java.util.ArrayList;

@Service
public class ShopOrderServiceImpl implements ShopOrderService {

    ShopOrderRepository shopOrderRepository;
    OrderProductRepository orderProductRepository;

    public ShopOrderServiceImpl(ShopOrderRepository shopOrderRepository, OrderProductRepository orderProductRepository) {
        this.shopOrderRepository = shopOrderRepository;
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public ShopOrderDto getOrderDto() {
        int size = 0;
        if ((size = shopOrderRepository.findAll().size()) == 0) {
            return null;
        } else {
            return ShopOrderMapper.INSTANCE.shopOrderToDto(shopOrderRepository.findAll().get(size - 1));
        }
    }

    @Override
    public ShopOrder getOrder() {
        int size = 0;
        if ((size = shopOrderRepository.findAll().size()) == 0) {
            return null;
        } else {
            return shopOrderRepository.findAll().get(size - 1);
        }
    }

    @Override
    public void addOrder() {
        ShopOrder order = new ShopOrder();
        order.setTime(LocalTime.now());
        order.setTotalPrice(0);
        // List<OrderProduct> products = new ArrayList<>();
        // order.setOrderProducts(products);

        shopOrderRepository.save(order);
    }

    public void saveOrder(ShopOrder shopOrder) {
        actualize(shopOrder);
        shopOrderRepository.save(shopOrder);
    }

    public void actualize(ShopOrder shopOrder) {
        int totalPrice = 0;
        for(OrderProduct  orderProduct: shopOrder.getOrderProducts()) {
           totalPrice += orderProduct.getCount() * orderProduct.getPrice();
        }

        shopOrder.setTotalPrice(totalPrice);
    }
}
