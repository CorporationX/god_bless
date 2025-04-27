package school.faang.bjs274245;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();
    private Object lock = new Object();

    public void addView(String videoId) {
        synchronized (lock) {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (lock) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }
}
