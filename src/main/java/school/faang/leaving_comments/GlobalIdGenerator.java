package school.faang.leaving_comments;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class GlobalIdGenerator {
    private static final ConcurrentHashMap<Class<?>, AtomicInteger> idMap = new ConcurrentHashMap<>();

    public static int generateId(Class<?> clazz) {
        return idMap
                .computeIfAbsent(clazz, key -> new AtomicInteger(0))
                .incrementAndGet();
    }
}
