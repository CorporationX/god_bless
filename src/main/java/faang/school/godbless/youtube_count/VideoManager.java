package faang.school.godbless.youtube_count;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            if (!viewsMap.containsKey(videoId)) {
                viewsMap.put(videoId, 1);
            } else {
                viewsMap.put(videoId, viewsMap.get(videoId) + 1);
            }
        }
    }

    public synchronized void getViewCount(String videoId) {
        synchronized (viewsMap) {
            System.out.println(videoId + " - " + viewsMap.getOrDefault(videoId, 0));
        }
    }
}