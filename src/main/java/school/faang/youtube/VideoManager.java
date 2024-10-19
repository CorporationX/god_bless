package school.faang.youtube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {

    private final Map<String, Integer> videoToViews = new HashMap<>();

    public synchronized void addView(String video) {
        videoToViews.put(video, videoToViews.getOrDefault(video, 0) + 1);
    }

    public synchronized int getViewCount(String video) {
        return videoToViews.getOrDefault(video, 0);
    }
}
