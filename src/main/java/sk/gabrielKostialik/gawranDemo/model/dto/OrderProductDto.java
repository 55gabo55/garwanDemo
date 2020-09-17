package sk.gabrielKostialik.gawranDemo.model.dto;

import sk.gabrielKostialik.gawranDemo.model.ShopOrder;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OrderProductDto {
    private Long id;
    private long productId;
    private int price;
    private int count;

    public OrderProductDto() {
    }

    public OrderProductDto(Long id, long productId, int price, int count) {
        this.id = id;
        this.productId = productId;
        this.price = price;
        this.count = count;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
