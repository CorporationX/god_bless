package faang.school.godbless.multithreading.youtube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap;
    private final Object lock;

    public VideoManager() {
        viewsMap = new HashMap<>();
        lock = new Object();
    }

    public void addView(String videoId) {
        synchronized (lock) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (lock) {
            return viewsMap.get(videoId);
        }
    }

    public Map<String, Integer> getViewsMap() {
        return viewsMap;
    }
}
