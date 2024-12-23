package school.faang.sprint4.task50100.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private final int id;
    private OrderStatus status;

    public Order(int id) {
        this.id = id;
        status = OrderStatus.New;
    }

}
