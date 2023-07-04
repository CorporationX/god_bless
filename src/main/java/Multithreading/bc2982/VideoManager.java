package Multithreading.bc2982;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            if (viewsMap.containsKey(videoId)) {
                int count = viewsMap.get(videoId);
                viewsMap.put(videoId, count + 1);
            } else {
                viewsMap.put(videoId, 1);
            }
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            int result = 0;
            if (viewsMap.containsKey(videoId)) {
                result = viewsMap.get(videoId);
            }
            return result;
        }
    }
}
