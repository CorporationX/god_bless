package you_tube_view_counter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private static final Object LOCK = new Object();
    private Map<String, Long> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (LOCK) {
            if (!viewsMap.containsKey(videoId)) {
                viewsMap.put(videoId, 1L);
            }
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        }
    }

    public long getViewCount(String videoId) {
        synchronized (LOCK) {
            return viewsMap.getOrDefault(videoId, 0L);
        }
    }
}
