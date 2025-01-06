package school.faang.task_50101;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Order {
    private final int id;
    private OrderStatus status;
}