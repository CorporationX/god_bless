package bjs2_37510;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> views;

    public VideoManager() {
        this.views = new HashMap<>();
    }

    public synchronized void addView(String videoId) {
        views.putIfAbsent(videoId, 0);
        views.put(videoId, views.get(videoId) + 1);
    }

    public synchronized Integer getViewCount(String videoId) {
        return views.getOrDefault(videoId, 0);
    }
}
