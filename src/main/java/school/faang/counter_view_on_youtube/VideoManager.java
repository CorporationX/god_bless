package school.faang.counter_view_on_youtube;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class VideoManager {

    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        if (videoId == null || videoId.isEmpty()) {
            throw new IllegalArgumentException("Video ID cannot be null or empty");
        }
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public int getViews(String videoId) {
        if (videoId == null || videoId.isEmpty()) {
            throw new IllegalArgumentException("Video ID cannot be null or empty");
        }
        return viewsMap.getOrDefault(videoId, 0);
    }
}
