package school.faang_sprint_3.youtube_views_counter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, viewsMap.getOrDefault(videoId, 0));
    }
}
