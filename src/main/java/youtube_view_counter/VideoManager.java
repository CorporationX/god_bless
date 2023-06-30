package youtube_view_counter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap;

    public VideoManager() {
        viewsMap = new HashMap<>();
    }


    public synchronized void addView(String videoId) {
        int views = viewsMap.getOrDefault(videoId, 0);
        viewsMap.put(videoId, views + 1);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
