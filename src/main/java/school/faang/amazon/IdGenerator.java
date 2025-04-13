package school.faang.amazon;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    @Getter
    private static AtomicInteger id = new AtomicInteger();

    public static int idCounterUp() {
        return id.getAndIncrement();
    }
}