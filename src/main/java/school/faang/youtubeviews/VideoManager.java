package school.faang.youtubeviews;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.merge(videoId, 1, Integer::sum);
        }
    }

    public Optional<Integer> getViewCount(String videoId) {
        synchronized (viewsMap) {
            return Optional.ofNullable(viewsMap.get(videoId));
        }
    }
}
