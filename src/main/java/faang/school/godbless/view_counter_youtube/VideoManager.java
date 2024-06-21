package faang.school.godbless.view_counter_youtube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        if (viewsMap.containsKey(videoId)) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        } else {
            viewsMap.put(videoId, 0);
        }
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }
}
