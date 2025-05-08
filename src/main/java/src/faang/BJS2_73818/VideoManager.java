package src.faang.BJS2_73818;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        this.viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized int getViewCount(String videoId) {
        return this.viewsMap.get(videoId);
    }

    public synchronized Map<String, Integer> getViewsMap() {
        return new HashMap<>(this.viewsMap);
    }
}
