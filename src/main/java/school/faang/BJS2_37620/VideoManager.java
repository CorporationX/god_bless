package school.faang.BJS2_37620;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

    public void initializeVideos(int numVideos) {
        for (int i = 0; i < numVideos; i++) {
            viewsMap.put("video" + i, 0);
        }
    }

    public Map<String, Integer> getAllViews() {
        return viewsMap;
    }
}
