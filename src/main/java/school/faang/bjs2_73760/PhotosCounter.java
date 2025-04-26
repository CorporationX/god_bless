package school.faang.bjs2_73760;

import lombok.experimental.UtilityClass;

import java.util.concurrent.atomic.AtomicInteger;

@UtilityClass
public final class PhotosCounter {
    private static final AtomicInteger atomicInteger = new AtomicInteger();

    public static String getNextPhoto() {
        return String.format("Photo %d", atomicInteger.incrementAndGet());
    }
}
