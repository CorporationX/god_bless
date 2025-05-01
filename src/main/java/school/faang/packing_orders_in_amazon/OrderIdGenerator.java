package school.faang.packing_orders_in_amazon;

import java.util.concurrent.atomic.AtomicInteger;

public class OrderIdGenerator {
    private static final AtomicInteger counter = new AtomicInteger(1);

    private OrderIdGenerator() {
    }

    public static int generate() {
        return counter.getAndIncrement();
    }
}