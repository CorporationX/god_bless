package faang.school.godbless.multithreading.synchronized_wait_notify.youtube_view_counter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        if (viewsMap.containsKey(videoId)) viewsMap.put(videoId, viewsMap.get(videoId) + 1);
    }

    public synchronized int getViewCount(String videoId) {
        if (viewsMap.containsKey(videoId)) return viewsMap.get(videoId);
        throw new IllegalArgumentException("video by " + videoId + " is not found");
    }

    public Map<String, Integer> getViewsMap() {
        return viewsMap;
    }
}
