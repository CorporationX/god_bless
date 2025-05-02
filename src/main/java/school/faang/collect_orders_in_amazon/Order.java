package school.faang.collect_orders_in_amazon;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order {
    private final int id;
    @Setter
    private String status;

    public Order(int id, String status) {
        this.id = id;
        this.status = status;
    }
}
