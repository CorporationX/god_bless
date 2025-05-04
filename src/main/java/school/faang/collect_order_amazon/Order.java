package school.faang.collect_order_amazon;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order {
    private final int id;
    @Setter
    private boolean isFinished;

    public Order(int id) {
        this.id = id;
        isFinished = false;
    }
}
