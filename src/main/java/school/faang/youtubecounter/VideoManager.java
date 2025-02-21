package school.faang.youtubecounter;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap;

    public VideoManager() {
        viewsMap = new HashMap<>();
    }

    public synchronized void addView(@NonNull String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized int getViewCount(@NonNull String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
