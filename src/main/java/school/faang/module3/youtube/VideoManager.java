package school.faang.module3.youtube;

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
        return viewsMap.getOrDefault(videoId, 0);
    }
}
