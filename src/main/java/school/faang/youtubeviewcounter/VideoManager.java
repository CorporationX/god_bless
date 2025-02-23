package school.faang.youtubeviewcounter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();
    private final Object lock = new Object();

    public void addView(String videoId) {
        synchronized (lock) {
            viewsMap.compute(videoId, (key, value) -> (value == null) ? 1 : value + 1);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (lock) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }
}