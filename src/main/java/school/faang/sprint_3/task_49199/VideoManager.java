package school.faang.sprint_3.task_49199;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        ValidationUtils.isNotNull(videoId, "Номер видео");
        viewMap.put(videoId, viewMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized int getViewCount(String videoId) {
        ValidationUtils.isNotNull(videoId, "Номер видео");
        return viewMap.getOrDefault(videoId, 0);
    }

    public Map<String, Integer> getViewMap() {
        return viewMap;
    }
}
