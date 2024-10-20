package school.faang.counteryoutube;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.computeIfAbsent(videoId, k -> 0);
        viewsMap.compute(videoId, (k, v) -> v + 1);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }
}
