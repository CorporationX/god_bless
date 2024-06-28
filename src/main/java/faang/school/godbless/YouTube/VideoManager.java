package faang.school.godbless.YouTube;

import lombok.Data;
import lombok.Getter;

import java.util.Map;

@Getter
public class VideoManager {
    private Map<String, Integer> viewsMap;

    public VideoManager(Map<String, Integer> viewsMap) {
        if (viewsMap.isEmpty() || viewsMap == null) {
            throw new IllegalArgumentException(
                    "VideoManager class in constructor apply empty or null Map");
        }
        this.viewsMap = viewsMap;
    }

    public synchronized void addView(String videoId) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
    }

    public synchronized int getViewCount(String videoId) {
            return viewsMap.get(videoId);
    }
}
