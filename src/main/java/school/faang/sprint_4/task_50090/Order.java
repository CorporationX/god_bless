package school.faang.sprint_4.task_50090;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private int id;
    private OrderStatus status;
}
