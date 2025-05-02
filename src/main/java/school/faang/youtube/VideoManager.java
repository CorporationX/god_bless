package school.faang.youtube;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        synchronized (getLock(videoId)) {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (getLock(videoId)) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }

    private Object getLock(String videoId) {
        return videoId.intern();
    }
}
