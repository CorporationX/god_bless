package school.faang.task_43518;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static final AtomicLong COUNTER = new AtomicLong(0);

    public static long getNextId() {
        return COUNTER.getAndIncrement();
    }
}
