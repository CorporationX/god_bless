package bjs290001;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();
    private final Object lockVideoCounting = new Object();

    public void addView(String videoId) {
        synchronized (lockVideoCounting) {
            if (viewsMap.containsKey(videoId)) {
                viewsMap.put(videoId, viewsMap.get(videoId) + 1);
            } else {
                viewsMap.put(videoId, 1);
            }
        }
    }

    public Integer getViewCount(String videoId) {
        synchronized (lockVideoCounting) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }
}
