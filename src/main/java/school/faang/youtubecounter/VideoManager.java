package school.faang.youtubecounter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.compute(videoId, (k, v) -> (v == null) ? 1 : v + 1);
    }

    public synchronized Integer getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }
}
