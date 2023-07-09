package Multithreading.bc2982;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {

        if (viewsMap.containsKey(videoId)) {
            int count = viewsMap.get(videoId);
            viewsMap.put(videoId, count + 1);

        } else {
            viewsMap.put(videoId, 1);
        }
        System.out.println(videoId + " add view " + viewsMap.get(videoId));
    }

    public synchronized int getViewCount(String videoId) {

        int result = 0;
        if (viewsMap.containsKey(videoId)) {
            result = viewsMap.get(videoId);
        }
        return result;
    }
}
