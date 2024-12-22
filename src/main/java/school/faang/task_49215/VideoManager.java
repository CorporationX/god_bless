package school.faang.task_49215;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class VideoManager {
    private final Map<String, Integer> views = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        views.put(videoId, views.getOrDefault(videoId, 0) + 1);
    }

    public int getViewCount(String videoId) {
        return views.getOrDefault(videoId, 0);
    }
}
