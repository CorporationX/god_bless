package school.faang.BJS2_61948;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static final AtomicInteger currentId = new AtomicInteger(0);
    @Getter
    private final int id;
    private StatusType status;

    public Order() {
        id = currentId.addAndGet(1);
        status = StatusType.NEW;
    }

    public synchronized StatusType getStatus() {
        return status;
    }

    public synchronized void setStatus(StatusType status) {
        this.status = status;
    }
}
