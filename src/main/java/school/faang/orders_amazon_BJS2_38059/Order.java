package school.faang.orders_amazon_BJS2_38059;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Order {
    private int id;
    private OrderStatus status;
}