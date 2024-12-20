package school.faang.task_49191;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoManager {
    private final Map<String, AtomicInteger> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        viewsMap.computeIfAbsent(videoId, key -> new AtomicInteger(0)).incrementAndGet();
    }

    public int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, new AtomicInteger(0)).get();
    }
}