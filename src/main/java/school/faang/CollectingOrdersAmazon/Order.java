package school.faang.CollectingOrdersAmazon;

import lombok.Data;

@Data
public class Order {
    private int id;
    private OrderStatus status;
    private String errorMessage;

    Order(int id, OrderStatus status) {
        this.id = id;
        this.status = status;
    }
}
