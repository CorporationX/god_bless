package school.faang.youtube_view_couner_BJS2_37485;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();
    private final Object lock = new Object();

    public void addView(String videoId) {
        synchronized (lock) {
            viewsMap.computeIfAbsent(videoId, k -> 0);
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (lock) {
            return viewsMap.get(videoId);
        }
    }
}
