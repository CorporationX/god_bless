package faang.school.godbless.youtube_view_counter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }
}
