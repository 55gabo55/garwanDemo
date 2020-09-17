package sk.gabrielKostialik.gawranDemo.service.impl;

import org.springframework.stereotype.Service;
import sk.gabrielKostialik.gawranDemo.model.OrderProduct;
import sk.gabrielKostialik.gawranDemo.repository.OrderProductRepository;
import sk.gabrielKostialik.gawranDemo.service.api.OrderProductService;

@Service
public class OrderProductServiceImpl implements OrderProductService {

    OrderProductRepository orderProductRepository;

    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderProduct addOrderProduct(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }
}
