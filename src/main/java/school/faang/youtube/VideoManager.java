package school.faang.youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        log.debug("Thread {}: calling addView()", Thread.currentThread().getId());
        viewsMap.merge(videoId, 1, Integer::sum);
        log.debug("Thread {}: added a new view for {}", Thread.currentThread().getId(), videoId);
    }

    public synchronized Integer getViewCount(String videoId) {
        log.debug("Thread {}: calling getViewCount()", Thread.currentThread().getId());
        Integer views;
        log.debug("Thread {}: Entered synchronized (viewsMap)", Thread.currentThread().getId());
        views = viewsMap.getOrDefault(videoId, 0);
        log.info("Thread {}: views for video {} = {}", Thread.currentThread().getId(), videoId, views);
        return views;
    }
}
