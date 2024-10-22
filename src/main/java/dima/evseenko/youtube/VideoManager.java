package dima.evseenko.youtube;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    @Getter
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized Integer getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
