package school.faang.viewcounter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {

    private final Map<String, Integer> viewsMap = new HashMap<>();
    private final Object lock = new Object();

    public void addView(String videoId) {
        synchronized (lock) {
            viewsMap.merge(videoId, 1, Integer::sum);
        }
    }

    public Integer getViewCount(String videoId) {
        synchronized (lock) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }
}
