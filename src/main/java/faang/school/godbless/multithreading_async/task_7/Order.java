package faang.school.godbless.multithreading_async.task_7;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private final int id;
    private Status status;

    public Order(int id) {
        this.id = id;
        status = Status.LOADING;
    }
}