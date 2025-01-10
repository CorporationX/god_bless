package faang.school.godbless.sprint_3.task_49322;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {

    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        checkVideoId(videoId);
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized int getViewCount(String videoId) {
        checkVideoId(videoId);
        if (!viewsMap.containsKey(videoId)) {
            throw new IllegalArgumentException("Video ID doesn't exist");
        }
        return viewsMap.get(videoId);
    }

    private void checkVideoId(String videoId) {
        if (videoId == null) {
            throw new IllegalArgumentException("Video ID cannot be null");
        }
        if (videoId.isBlank()) {
            throw new IllegalArgumentException("Video ID cannot be blank");
        }
    }
}
