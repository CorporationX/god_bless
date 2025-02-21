package school.faang.viewcounter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {

    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public Integer getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
