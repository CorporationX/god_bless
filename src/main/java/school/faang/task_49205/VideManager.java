package school.faang.task_49205;

import lombok.NonNull;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class VideManager {
    private final ConcurrentMap<String, Integer> viewsMap;

    public VideManager() {
        this.viewsMap = new ConcurrentHashMap<>();
    }

    public void addView(@NonNull String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public int getViewCount(@NonNull String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

}
