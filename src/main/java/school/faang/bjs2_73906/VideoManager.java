package school.faang.bjs2_73906;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        int videoViewCount = viewsMap.getOrDefault(videoId, 0) + 1;
        viewsMap.put(videoId, videoViewCount);
        log.info("The view of video with id = {} was added. The count is {}", videoId, videoViewCount);
    }

    public synchronized Integer getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
