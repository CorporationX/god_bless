package amazonorder;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {
    private int id;
    private OrderStatus status;

    public Order(int id, OrderStatus status) {
        this.id = id;
        this.status = status;
    }
}
