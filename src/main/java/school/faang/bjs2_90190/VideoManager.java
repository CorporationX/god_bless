package school.faang.bjs2_90190;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (this) {
            viewsMap.merge(videoId, 1, Integer::sum);
        }
    }

    public Integer getViewCount(String videoId) {
        synchronized (this) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }
}
