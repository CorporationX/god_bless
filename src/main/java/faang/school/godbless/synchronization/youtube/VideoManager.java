package faang.school.godbless.synchronization.youtube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {

    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            Integer views = viewsMap.get(videoId);
            if (views == null) {
                views = 0;
            }
            viewsMap.put(videoId, ++views);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }
}
