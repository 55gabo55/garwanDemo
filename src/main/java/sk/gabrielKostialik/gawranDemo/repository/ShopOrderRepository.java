package sk.gabrielKostialik.gawranDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.gabrielKostialik.gawranDemo.model.ShopOrder;

public interface ShopOrderRepository extends JpaRepository<ShopOrder, Long> {
}
