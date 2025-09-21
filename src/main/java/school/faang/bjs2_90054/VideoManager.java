package school.faang.bjs2_90054;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private static final int DEFAULT_COUNT_VIDEO = 0;
    private static final int INCREMENT_VIDEO = 1;
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, DEFAULT_COUNT_VIDEO) + INCREMENT_VIDEO);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, DEFAULT_COUNT_VIDEO);
    }
}
