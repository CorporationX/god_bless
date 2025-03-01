package school.faang.third_sprint;

import lombok.NonNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(@NonNull String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public int getViewCount(@NonNull String videoId) {
        return viewsMap.get(videoId);
    }
}
