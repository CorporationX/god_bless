package school.faang.synchronization.youtube;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public synchronized void addView(String videoId) {
        Integer value = viewsMap.get(videoId);
        if (value != null) {
            viewsMap.put(videoId, value + 1);
        } else {
            viewsMap.put(videoId, 1);
        }
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }

}
