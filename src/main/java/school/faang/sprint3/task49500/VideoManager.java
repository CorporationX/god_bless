package school.faang.sprint3.task49500;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private static final int INIT_VIEWS = 0;
    private final Map<String, Integer> viewsMap;

    public VideoManager() {
        viewsMap = new HashMap<>();
    }

    public synchronized void addView(String videoId) {
        int numOfViews = viewsMap.getOrDefault(videoId, INIT_VIEWS);
        numOfViews++;
        viewsMap.put(videoId, numOfViews);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, INIT_VIEWS);
    }
}
