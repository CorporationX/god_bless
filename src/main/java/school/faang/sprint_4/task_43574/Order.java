package school.faang.sprint_4.task_43574;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Order {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    private final int id;
    private Status status;

    public Order(Status status) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.status = status;
    }
}