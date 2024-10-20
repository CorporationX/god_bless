package school.faang.synchcountview;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public synchronized void addView(String videoId) {
        Integer value = viewsMap.computeIfAbsent(videoId, key -> 0);
        value++;
        viewsMap.put(videoId, value);
    }

    public synchronized Integer getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

}
