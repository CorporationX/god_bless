package youtoube_views_count;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap;

    public VideoManager() {
        this.viewsMap = new HashMap<>();
    }

    public synchronized void addView(String videoId) {
        int views = viewsMap.getOrDefault(videoId, 0);
        viewsMap.put(videoId, views + 1);
    }

    public synchronized int getViewCount(String videId) {
        return viewsMap.getOrDefault(videId,0);
    }
}
