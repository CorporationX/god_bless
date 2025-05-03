package school.faang.bjs2_73853;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.compute(videoId, (key, value) -> value == null ? 1 : value + 1);
    }

    public synchronized int getViewCount(String videoId) {
        return Optional.of(viewsMap.get(videoId))
                .orElseThrow(() -> new IllegalArgumentException("Video with id %s not found".formatted(videoId)));
    }
}