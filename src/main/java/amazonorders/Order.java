package amazonorders;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private int id;
    private OrderStatus status;
}