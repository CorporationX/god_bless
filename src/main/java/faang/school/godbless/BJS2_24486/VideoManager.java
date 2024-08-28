package faang.school.godbless.BJS2_24486;

import java.util.HashMap;
import java.util.Optional;

public class VideoManager {
    private final HashMap<String, Long> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0L) + 1L);
    }

    public synchronized Optional<Long> getViewCount(String videoId) {
        return Optional.ofNullable(viewsMap.get(videoId));
    }
}
