package school.faang.collect_order_amazon;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order {
    private final int id;
    @Setter
    private boolean status;

    public Order(int id) {
        this.id = id;
        status = false;
    }
}
