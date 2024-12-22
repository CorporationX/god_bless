package school.faang.sprint_3.task_49235;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoManager {
    private Map<String, AtomicInteger> views = new HashMap<>();

    public synchronized void addView(String videoId) {
        views.computeIfAbsent(videoId, (key) -> new AtomicInteger(1)).incrementAndGet();
    }

    public synchronized int getViewCount(String videoId) {
        return views.getOrDefault(videoId, new AtomicInteger(0)).get();
    }
}
