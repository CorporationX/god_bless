package school.faang.multithreading.asynchronism.collect.orders.amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private final int id;
    private OrderStatus status;
}
