package mod1sp3.youtubeViewCounter;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.get(videoId) + 1);
    }

    public synchronized Integer getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }
}
