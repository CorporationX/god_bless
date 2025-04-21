package school.faang.bjs2_69898;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private final AtomicInteger counter = new AtomicInteger(0);

    public int generateId() {
        return counter.incrementAndGet();
    }
}