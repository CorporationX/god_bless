package school.faang.sprint3.bjs_49172;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(@NonNull String videoId) {
        int counter = viewsMap.getOrDefault(videoId, 0) + 1;
        viewsMap.put(videoId, counter);
    }

    public synchronized int getViewCount(@NonNull String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
