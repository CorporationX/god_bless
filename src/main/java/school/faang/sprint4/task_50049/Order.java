package school.faang.sprint4.task_50049;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

import static school.faang.sprint4.task_50049.OrderStatus.PROCESSED;

@AllArgsConstructor
@Getter
public class Order {
    private final int id;
    private OrderStatus status;

    public boolean process() {
        if (Objects.equals(status, PROCESSED)) {
            return false;
        }
        status = PROCESSED;
        return true;
    }
}
