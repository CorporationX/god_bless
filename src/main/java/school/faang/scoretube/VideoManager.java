package school.faang.scoretube;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {

    private Map<String, Integer> viewsMap = new ConcurrentHashMap<>();
    private int videoScore;

    public synchronized void addView(String videoId) {
        viewsMap.computeIfPresent(videoId, (k, v) -> v + 1);
    }

    public synchronized int getVideoCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

}
