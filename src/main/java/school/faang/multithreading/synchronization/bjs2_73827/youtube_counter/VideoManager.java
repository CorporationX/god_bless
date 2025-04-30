package school.faang.multithreading.synchronization.bjs2_73827.youtube_counter;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewMap = new HashMap<>();
    private final Object lock = new Object();

    public void addView(String videoId) {
        synchronized (lock) {
            viewMap.compute(videoId, (k, v) -> v == null ? 1 : v + 1);
            log.info("Added view: video = {}, views = {}", videoId, viewMap.get(videoId));
        }
    }

    public long getViewCount(String videoId) {
        synchronized (lock) {
            return viewMap.getOrDefault(videoId, 0);
        }
    }

    public void printViews() {
        synchronized (lock) {
            for (Map.Entry<String, Integer> entry : viewMap.entrySet()) {
                log.info(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
