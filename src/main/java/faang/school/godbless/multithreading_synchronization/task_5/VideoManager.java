package faang.school.godbless.multithreading_synchronization.task_5;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        if (viewsMap.containsKey(videoId)) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        } else {
            viewsMap.put(videoId, 1);
        }
    }

    public synchronized int getViewCount(String videoId) {
        if (viewsMap.containsKey(videoId)) {
            return viewsMap.get(videoId);
        } else {
            throw new IllegalArgumentException("Video ID not found: " + videoId);
        }
    }
}
