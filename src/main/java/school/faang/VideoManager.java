package school.faang;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private final Map<String, Integer> viewsCount = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsCount.merge(videoId, 1, Integer::sum);
    }

    public int getViewCount(String videoId) {
        return viewsCount.getOrDefault(videoId, 0);
    }
}
