package my.test.app1.domain;

import java.util.List;

public class OrderDto {

    private String description;

    private List<OrderItemDto> orderItems;

    private long id;

    public OrderDto(String description, List<OrderItemDto> orderItems, long id) {
        this.description = description;
        this.orderItems = orderItems;
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public long getId() {
        return id;
    }
}
