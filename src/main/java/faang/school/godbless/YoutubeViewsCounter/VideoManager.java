package faang.school.godbless.YoutubeViewsCounter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addVideo(String videoId) {
        synchronized (viewsMap) {
            viewsMap.put(videoId, 0);
        }
    }

    public void addView(String videoId) {
        synchronized (viewsMap) {
            if (viewsMap.containsKey(videoId)) {
                viewsMap.put(videoId, viewsMap.get(videoId) + 1);
            }
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            return viewsMap.getOrDefault(videoId, -1);
        }
    }
}
