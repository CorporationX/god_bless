package school.faang.amazon;

import lombok.Data;

@Data
public class Order {
    private static int idIncrement;
    private int id;
    private OrderStatus status;

    public Order() {
        this.id = ++idIncrement;
        this.status = OrderStatus.NEW;
    }
}
