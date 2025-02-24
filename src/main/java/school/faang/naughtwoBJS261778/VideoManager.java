package school.faang.naughtwoBJS261778;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(@NonNull String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized int getViewCount(@NonNull String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}

