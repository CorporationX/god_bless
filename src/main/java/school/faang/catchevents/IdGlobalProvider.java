package school.faang.catchevents;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGlobalProvider {
    private static final AtomicInteger id = new AtomicInteger(0);

    public static int getId() {
        return id.incrementAndGet();
    }
}