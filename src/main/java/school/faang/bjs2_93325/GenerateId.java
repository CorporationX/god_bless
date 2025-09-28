package school.faang.bjs2_93325;

import java.util.concurrent.atomic.AtomicInteger;

public class GenerateId {
    private static final AtomicInteger atomicCounter = new AtomicInteger(0);

    public static int getId() {
        return atomicCounter.incrementAndGet();
    }
}
