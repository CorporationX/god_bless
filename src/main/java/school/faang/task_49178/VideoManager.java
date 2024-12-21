package school.faang.task_49178;

import school.faang.exception.CheckException;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        if (videoId == null || videoId.isEmpty()) {
            throw new CheckException("videoId");
        }
        synchronized (viewsMap) {
            viewsMap.merge(videoId, 1, Integer::sum);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }
}
