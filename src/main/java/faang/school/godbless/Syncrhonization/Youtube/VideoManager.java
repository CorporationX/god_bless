package faang.school.godbless.Syncrhonization.Youtube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }
}
