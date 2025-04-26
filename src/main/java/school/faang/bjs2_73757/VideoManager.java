package school.faang.bjs2_73757;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {

    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (this) {
            viewsMap.merge(videoId, 1, Integer::sum);
            log.info("Video -> {}, now has views -> {}", videoId, viewsMap.get(videoId));
        }
    }

    public int getViewCount(String videoId) {
        synchronized (this) {
            return viewsMap.get(videoId);
        }
    }
}
