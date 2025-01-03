package school.faang.amazon_orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Order {
    private final int id;
    @Setter
    private OrderStatus status;
}
