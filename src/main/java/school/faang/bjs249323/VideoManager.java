package school.faang.bjs249323;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();
    //new ConcurrentHashMap<>();
    //Collections.synchronizedMap(new HashMap<>());

    public synchronized void addView(String videoId) {
        int currentNewVideoViewsCount = getViewCount(videoId) + 1;
        viewsMap.put(videoId, currentNewVideoViewsCount);
        System.out.println(videoId + " views count is: " + currentNewVideoViewsCount);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
