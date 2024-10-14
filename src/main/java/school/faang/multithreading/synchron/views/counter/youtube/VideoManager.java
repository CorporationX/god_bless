package school.faang.multithreading.synchron.views.counter.youtube;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
