package school.faang.bjs273835;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {
    private static final int DEFAULT_VIEW_COUNT = 0;

    private final Map<String, Integer> viewMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        int currentCount = viewMap.computeIfAbsent(videoId, count -> DEFAULT_VIEW_COUNT);
        viewMap.put(videoId, ++currentCount);
        log.info("Viewed {}, current views:  {}", videoId, currentCount);
    }

    public synchronized int getViewCount(String videoId) {
        return viewMap.getOrDefault(videoId, DEFAULT_VIEW_COUNT);
    }
}
