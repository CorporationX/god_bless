package school.faang.BJS2_38113_AmazonOrders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Order {
    private int id;

    @Setter
    private OrderStatus status;
}
