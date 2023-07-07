package faang.school.godbless.thirdSprint.YouTube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<Integer, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(int videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized int getViewCount(int videoId) {
        return viewsMap.get(videoId);
    }
}
