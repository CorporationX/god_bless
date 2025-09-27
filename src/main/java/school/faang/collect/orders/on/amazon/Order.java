package school.faang.collect.orders.on.amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Order {
    private final int id;
    private OrderStatus status;
}
