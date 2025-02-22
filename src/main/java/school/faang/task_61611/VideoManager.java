package school.faang.task_61611;

import java.util.HashMap;
import java.util.Map;


public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        int currentViews = viewsMap.getOrDefault(videoId, 0);
        viewsMap.put(videoId, currentViews + 1);
    }

    public int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
