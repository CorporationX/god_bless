package school.faang.youtubecounter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoManager {
    private final Map<String, AtomicInteger> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsMap.compute(videoId, (k, v) -> {
            if (v == null) {
                return new AtomicInteger(1);
            }
            v.incrementAndGet();
            return v;
        });
    }

    public int getViewCount(String videoId) {
        AtomicInteger counter = viewsMap.get(videoId);
        return counter != null ? counter.get() : 0;
    }
}