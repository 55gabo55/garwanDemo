package sk.gabrielKostialik.gawranDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk.gabrielKostialik.gawranDemo.mapper.ShopOrderMapper;
import sk.gabrielKostialik.gawranDemo.model.OrderProduct;
import sk.gabrielKostialik.gawranDemo.model.ShopOrder;
import sk.gabrielKostialik.gawranDemo.model.dto.ProductDto;
import sk.gabrielKostialik.gawranDemo.service.api.OrderProductService;
import sk.gabrielKostialik.gawranDemo.service.api.ProductService;
import sk.gabrielKostialik.gawranDemo.service.api.ShopOrderService;

import java.util.List;

@Controller
public class ProductController {

    ProductService productService;
    ShopOrderService shopOrderService;
    OrderProductService orderProductService;

    public ProductController(ProductService productService, ShopOrderService shopOrderService, OrderProductService orderProductService) {
        this.productService = productService;
        this.shopOrderService = shopOrderService;
        this.orderProductService = orderProductService;
    }

    @GetMapping("/product")
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/buyProduct/{id}")
    public String buyProductInfo(Model model, @PathVariable("id") long id) {
        ProductDto productDto = productService.getProduct(id);
        model.addAttribute("product", productDto);



        OrderProduct orderProduct = new OrderProduct();
        model.addAttribute("orderProduct", orderProduct);

        return "buyProduct.html";
    }

    @PostMapping("/buyProduct/{productId}/{price}")
    public String buyProduct(@ModelAttribute("orderProduct") OrderProduct orderProduct, @PathVariable("productId") long productId, @PathVariable("price") int price) {
        ShopOrder shopOrder = shopOrderService.getOrder();
        orderProduct.setProductId(productId);

        if (shopOrder == null) {
            shopOrderService.addOrder();
            shopOrder = shopOrderService.getOrder();
        }
        orderProduct.setShopOrder(shopOrder);
        OrderProduct orderProduct1 = orderProductService.addOrderProduct(orderProduct);

        shopOrder.getOrderProducts().add(orderProduct1);
        shopOrderService.saveOrder(shopOrder);

        return "redirect:/listProducts";
    }

    @GetMapping("/product/{id}")
    public String getProductDetail(Model model, @PathVariable("id") long id) {
        ProductDto productDto = productService.getProduct(id);
        model.addAttribute("product", productDto);

        return "productInfo.html";
    }

    @GetMapping("/listProducts")
    public String listProduct(Model model) {
        model.addAttribute("products", productService.getAll());

        return "listProducts.html";
    }

    @GetMapping("/")
    public String home() {
        System.out.println("Going home...");
        return "index.html";
    }
}
