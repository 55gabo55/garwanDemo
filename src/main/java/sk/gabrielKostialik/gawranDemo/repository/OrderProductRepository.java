package sk.gabrielKostialik.gawranDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.gabrielKostialik.gawranDemo.model.OrderProduct;
import sk.gabrielKostialik.gawranDemo.model.ShopOrder;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
