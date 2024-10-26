package school.faang.sprint3.youtubeview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private Map<String, Integer> viewsMap;

    public VideoManager() {
        viewsMap = new ConcurrentHashMap<>();
    }

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }


    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);


    }
}



