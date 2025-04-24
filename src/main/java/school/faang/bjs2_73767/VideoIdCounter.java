package school.faang.bjs2_73767;

import lombok.experimental.UtilityClass;

import java.util.concurrent.atomic.AtomicInteger;

@UtilityClass
public final class VideoIdCounter {
    private static final AtomicInteger VIDEO_ID_COUNTER = new AtomicInteger();

    public static String getNextVideoId() {
        return String.valueOf(VIDEO_ID_COUNTER.incrementAndGet());
    }
}
