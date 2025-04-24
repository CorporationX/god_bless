package school.faang.bjs2_73767;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            Integer countViews = viewsMap.get(videoId);
            if (countViews == null) {
                log.error("Video with {} not found", videoId);
                throw new VideoNotFoundException(videoId);
            }
            return countViews;
        }
    }
}
