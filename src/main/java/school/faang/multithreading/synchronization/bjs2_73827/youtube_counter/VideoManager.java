package school.faang.multithreading.synchronization.bjs2_73827.youtube_counter;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewMap) {
            viewMap.merge(videoId, 1, Integer::sum);
            log.info("Added view: video = {}, views = {}", videoId, viewMap.get(videoId));
        }
    }

    public long getViewCount(String videoId) {
        synchronized (viewMap) {
            return viewMap.getOrDefault(videoId, 0);
        }
    }

    public void printViews() {
        synchronized (viewMap) {
            viewMap.forEach((key, value) -> log.info(key + " : " + value));
        }
    }
}
