package youtube_views;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();
    private final Object viewsMapLock = new Object();
    private final Random random = new Random();

    public Map<String, Integer> getViewsMap() {
        return viewsMap;
    }

    public void addView(String videoId) {
        synchronized (viewsMapLock) {
            Integer views = viewsMap.get(videoId);
                if (views != null) {
                    viewsMap.put(videoId, views + random.nextInt(1, 111));
                }
        }
    }

    public int getViewCount(String videoId) {
        int views = 0;
        synchronized (viewsMapLock) {
            Integer count = viewsMap.get(videoId);
            if (count != null) {
                views = count;
            }
        }
        return views;
    }
}
