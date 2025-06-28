package school.faang.bjs2_82216;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private final int id;
    private OrderStatus status;
}
