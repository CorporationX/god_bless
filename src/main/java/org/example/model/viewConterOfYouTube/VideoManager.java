package org.example.model.viewConterOfYouTube;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.computeIfPresent(videoId, (id, value) -> {
                return viewsMap.get(id) + 1;
            });
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }

    public void addVideo(String videoId) {
        synchronized (viewsMap) {
            viewsMap.put(videoId, 0);
        }
    }
}
