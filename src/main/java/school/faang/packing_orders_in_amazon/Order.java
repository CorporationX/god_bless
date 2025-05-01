package school.faang.packing_orders_in_amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Order {
    private final int id = OrderIdGenerator.generate();
    private OrderStatus status;
}