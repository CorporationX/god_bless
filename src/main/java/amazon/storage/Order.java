package amazon.storage;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order {
    private static int idCount = 1;
    private final int id;
    @Setter
    private OrderStatus status;

    public Order() {
        id = idCount++;
        status = OrderStatus.CREATED;
    }
}
