package faang.school.godbless.YoutubeViewsCounter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addVideo(String videoId) {
        viewsMap.put(videoId, 0);
    }

    public synchronized void addView(String videoId) {
        if (viewsMap.containsKey(videoId)) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        }
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, -1);
    }
}
