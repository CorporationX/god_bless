package sprint_4.sprint_4_1_async_future.collectOrdersAmazon_38107;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private OrderStatus status;
}
