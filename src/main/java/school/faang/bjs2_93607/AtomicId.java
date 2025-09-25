package school.faang.bjs2_93607;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicId {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static int getId() {
        return atomicInteger.incrementAndGet();
    }
}
