package school.faang.collection.hogwarts;

import java.util.concurrent.atomic.AtomicInteger;

public class IdProvider {

    private static final AtomicInteger ID_COUNTER = new AtomicInteger(1);

    public static int getId() {
        return ID_COUNTER.getAndIncrement();
    }
}