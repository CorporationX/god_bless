package school.faang.score_youtube;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}