package faang.school.godbless.collectingordersatamazon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private long id;
    private Status status;

    public Order(long id) {
        this.id = id;
        this.status = Status.IN_PROGRESS;
    }
}