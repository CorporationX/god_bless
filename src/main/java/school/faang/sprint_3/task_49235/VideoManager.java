package school.faang.sprint_3.task_49235;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private Map<String, Integer> views = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        views.merge(videoId, 1, Integer::sum);
    }

    public int getViewCount(String videoId) {
        return views.getOrDefault(videoId, 0);
    }
}
