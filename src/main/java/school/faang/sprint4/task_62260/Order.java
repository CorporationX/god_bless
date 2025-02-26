package school.faang.sprint4.task_62260;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@ToString
public class Order {
    private static final AtomicInteger idGenerator = new AtomicInteger();

    private final int id = idGenerator.getAndIncrement();
    @Setter
    private Status status = Status.TO_DO;
}
