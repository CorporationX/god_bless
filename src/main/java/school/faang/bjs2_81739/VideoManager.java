package school.faang.bjs2_81739;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {

    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        int currentViews = viewsMap.getOrDefault(videoId, 0);
        viewsMap.put(videoId, currentViews + 1);
        log.info("[{}] Added view to {} (total: {})",
                Thread.currentThread().getName(), videoId, currentViews + 1);
    }

    public synchronized int getViewCount(String videoId) {
        int count = viewsMap.getOrDefault(videoId, 0);
        log.info("[{}] Getting view count for {}: {}", Thread.currentThread().getName(), videoId, count);
        return count;
    }

    public synchronized Map<String, Integer> getAllViews() {
        return new HashMap<>(viewsMap);
    }
}
