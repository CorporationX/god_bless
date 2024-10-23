package school.faang.fourthStream.BJS2_38101;

import lombok.Data;

@Data
public class Order {
    private final int id;
    private OrderStatus status;

    public Order(int id) {
        this.id = id;
        this.status = OrderStatus.PLACED;
    }
}
