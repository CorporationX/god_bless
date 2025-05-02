package school.faang.bjs2_75964;

import lombok.experimental.UtilityClass;

import java.util.concurrent.atomic.AtomicLong;

@UtilityClass
public final class OrderNumberCounter {
    private static final AtomicLong NUMBER = new AtomicLong(0);

    public static long getNextOrderNumber() {
        return NUMBER.incrementAndGet();
    }
}
