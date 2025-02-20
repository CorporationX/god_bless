package school.faang;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private final Map<String, Integer> viewsCount = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsCount.put(videoId, viewsCount.getOrDefault(videoId, 0) + 1);
    }

    public int getViewCount(String videoId) {
        return viewsCount.getOrDefault(videoId, 0);
    }
}
