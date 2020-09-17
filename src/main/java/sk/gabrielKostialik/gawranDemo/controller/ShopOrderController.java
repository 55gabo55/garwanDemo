package sk.gabrielKostialik.gawranDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sk.gabrielKostialik.gawranDemo.model.OrderProduct;
import sk.gabrielKostialik.gawranDemo.model.ShopOrder;
import sk.gabrielKostialik.gawranDemo.service.api.ShopOrderService;

import java.util.List;
import java.util.Set;

@Controller
public class ShopOrderController {
    ShopOrderService shopOrderService;

    public ShopOrderController(ShopOrderService shopOrderService) {
        this.shopOrderService = shopOrderService;
    }

    @GetMapping("myOrder")
    public String myOrder(Model model) {
        ShopOrder shopOrder = shopOrderService.getOrder();
        if(shopOrder == null) {
            return "myOrderError.html";
        } else {
            Set<OrderProduct> orderProducts = shopOrder.getOrderProducts();
            model.addAttribute("shopOrder", shopOrder);
            return "myOrder.html";
        }
    }
}
