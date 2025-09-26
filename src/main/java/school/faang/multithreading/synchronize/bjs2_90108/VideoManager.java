package school.faang.multithreading.synchronize.bjs2_90108;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private static final Map<String, Integer> viewsMap = new HashMap<>();
    private static final Object lock = new Object();

    public void addView(String videoId) {
        synchronized (lock) {
            viewsMap.merge(videoId, 1, Integer::sum);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (lock) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }
}