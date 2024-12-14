package school.faang.s13task45124;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static final AtomicLong idCounter = new AtomicLong(0);

    private IdGenerator() {
    }

    public static long generateId() {
        return idCounter.incrementAndGet();
    }
}