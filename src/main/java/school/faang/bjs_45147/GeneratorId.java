package school.faang.bjs_45147;

import java.util.concurrent.atomic.AtomicInteger;

public class GeneratorId {
    private static final AtomicInteger PRODUCT_ID_COUNTER = new AtomicInteger();

    public static int createProductId() {
        return PRODUCT_ID_COUNTER.getAndIncrement();
    }
}
