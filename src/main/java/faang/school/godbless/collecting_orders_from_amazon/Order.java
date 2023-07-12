package faang.school.godbless.collecting_orders_from_amazon;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {
    private int id;
    private String status = "not processed";

    public Order(int id) {
        this.id = id;
    }
}
