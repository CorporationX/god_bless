package school.faang.youtube_view_counter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();
    private final Map<String, Object> lockMap = new HashMap<>();

    public void addVideo(String videoId) {
        if (!viewsMap.containsKey(videoId)) {
            viewsMap.put(videoId, 0);
            lockMap.put(videoId, new Object());
        }
    }

    public void addView(String videoId) {
        synchronized (lockMap.get(videoId)) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        }
    }

    public synchronized int getViewCount(String videoId) {
        synchronized (lockMap.get(videoId)) {
            return viewsMap.get(videoId);
        }
    }
}
