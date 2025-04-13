package school.faang.amazon;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final AtomicInteger id = new AtomicInteger(0);

    public static int getId() {
        return id.incrementAndGet();
    }
}