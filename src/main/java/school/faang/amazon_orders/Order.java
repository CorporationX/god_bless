package school.faang.amazon_orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Order {
    private final int id;
    @Getter
    @Setter
    private OrderStatus status;
}
