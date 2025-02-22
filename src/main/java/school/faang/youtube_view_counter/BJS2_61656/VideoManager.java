package school.faang.youtube_view_counter.BJS2_61656;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public synchronized Integer getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }
}
