package school.faang.task_49238;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> views = new HashMap<>();
    private final Object lock = new Object();

    public void addView(@NonNull String videoId) {
        synchronized (lock) {
            validateVideoId(videoId);
            views.put(videoId, views.getOrDefault(videoId, 0) + 1);
        }
    }

    public int getViewCount(@NonNull String videoId) {
        synchronized (lock) {
            validateVideoId(videoId);
            return views.get(videoId);
        }
    }

    private void validateVideoId(String videoId) {
        if (videoId.isBlank()) {
            throw new IllegalArgumentException("Video id is required");
        }
    }
}
