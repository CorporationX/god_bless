package faang.school.godbless.BJS2_24696;

import lombok.Getter;

@Getter
public class Order {
    private final long id;
    private Status status;

    public Order(long id) {
        this.id = id;
        status = Status.NEW;
    }

    public void markDone() {
        status = Status.DONE;
    }
}
