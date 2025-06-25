package school.faang.bjs2_82181_amazon_orders_count;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Order {
    private final int orderId;
    private OrderStatus status;
}
