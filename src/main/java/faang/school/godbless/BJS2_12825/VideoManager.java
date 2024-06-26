package faang.school.godbless.BJS2_12825;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    synchronized public void addView(String videoId) {
            Integer views = viewsMap.getOrDefault(videoId, 0);
            viewsMap.put(videoId, views + 1);
    }

    synchronized public int getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }
}
