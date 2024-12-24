package school.faang.sprint_4.task_50028;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private final int id;
    private OrderStatus status;
}
