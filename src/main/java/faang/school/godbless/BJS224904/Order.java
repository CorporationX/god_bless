package faang.school.godbless.BJS224904;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private final long id;
    private Status status;

    public Order(long id) {
        this.id = id;
        this.status = Status.IN_PROGRESS;
    }
}
