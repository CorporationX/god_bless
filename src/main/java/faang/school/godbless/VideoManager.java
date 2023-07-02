package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap;

    public VideoManager() {
        this.viewsMap = new HashMap<>();
    }
    public synchronized void addView(String videoId) {
        int currentViews = viewsMap.getOrDefault(videoId, 0);
        viewsMap.put(videoId, currentViews + 1);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
