package school.faang.sprint_4.task_bjs250382;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Order {
    private final int id;
    @Setter
    private OrderType type;
}
