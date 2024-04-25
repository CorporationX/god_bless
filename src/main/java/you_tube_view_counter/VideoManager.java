package you_tube_view_counter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private static final Object LOCK = new Object();
    private Map<String, Long> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (LOCK) {
            long views = viewsMap.getOrDefault(videoId, 0L);
            viewsMap.put(videoId, views + 1);
        }
    }

    public long getViewCount(String videoId) {
        synchronized (LOCK) {
            return viewsMap.getOrDefault(videoId, 0L);
        }
    }
}
