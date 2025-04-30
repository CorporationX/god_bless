package school.faang.youtube;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoManager {
    private Map<String, AtomicInteger> views = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        views.computeIfAbsent(videoId, id -> new AtomicInteger(0)).incrementAndGet();
    }

    public Integer getViewCount(String videoId) {
        return views.getOrDefault(videoId, new AtomicInteger(0)).get();
    }
}
