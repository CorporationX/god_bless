package school.faang.sprint4.task_50229;

import lombok.Data;
import static school.faang.sprint4.task_50229.OrderStatus.NEW;

@Data
public class Order {
    private final int id;
    private OrderStatus status = NEW;
}
