package school.faang.ordersinamazon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Order {
    private int id;
    private OrderStatus status;
}
