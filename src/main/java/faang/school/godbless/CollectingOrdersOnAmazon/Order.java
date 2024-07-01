package faang.school.godbless.CollectingOrdersOnAmazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private String id;
    private OrderStatus status;
}