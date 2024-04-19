package faang.school.godbless.youtube_view_counter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<Integer, Integer> viewMap;

    public VideoManager() {
        this.viewMap = new HashMap<>();
    }

    public void addView(int videoId) {
        synchronized (viewMap) {
            viewMap.put(videoId, viewMap.getOrDefault(videoId, 0) + 1);
        }
    }

    public int getViewCount(int videoId) {
        synchronized (viewMap) {
            return viewMap.get(videoId) == null ? 0 : viewMap.get(videoId);
        }
    }
}