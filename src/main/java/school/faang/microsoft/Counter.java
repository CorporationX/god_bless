package school.faang.microsoft;

import lombok.experimental.UtilityClass;

import java.util.concurrent.atomic.AtomicInteger;

@UtilityClass
public class Counter {
    public static AtomicInteger count = new AtomicInteger(0);
}
