package school.faang.BJS2_38154;

import lombok.Data;
@Data
public class Order {
    private int id;
    private OrderStatus status;

    public Order(int id, OrderStatus status) {
        this.id = id;
        this.status = status;
    }
}
