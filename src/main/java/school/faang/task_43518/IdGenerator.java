package school.faang.task_43518;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private final AtomicLong counter = new AtomicLong(0);

    public long getId() {
        return counter.getAndIncrement();
    }
}
