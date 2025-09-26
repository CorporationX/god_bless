package school.faang.bjs2_93325;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private static final AtomicInteger atomicCounter = new AtomicInteger(0);

    public static int getCount() {
        return atomicCounter.incrementAndGet();
    }
}
