package school.faang.bjs2_81750;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();
    private final Object lock = new Object();

    public void addView(String videoId) {
        synchronized (lock) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        }
    }

    public Integer getViewCount(String videoId) {
        synchronized (lock) {
            return viewsMap.get(videoId);
        }
    }
}
