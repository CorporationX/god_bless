package school.faang.module3.youtube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.merge(videoId, 1, (a, b) -> Integer.sum(a, b));
    }

    public synchronized Integer getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
