package school.faang.scoretube;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {

    private Map<String, Integer> viewsMap = new ConcurrentHashMap<>();
    private int videoScore;

    public synchronized void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public int getVideoCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

}
