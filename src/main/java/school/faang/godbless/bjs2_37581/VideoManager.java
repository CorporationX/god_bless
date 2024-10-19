package school.faang.godbless.bjs2_37581;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> views = new HashMap<>();

    public void addView(@NonNull String videoId) {
        if (videoId.isEmpty()) {
            log.error("Empty video id");
            return;
        }
        synchronized (views) {
            views.putIfAbsent(videoId, 0);
            views.put(videoId, views.get(videoId) + 1);
        }
    }

    public Optional<Integer> getViewCount(@NonNull String videoId) {
        synchronized (views) {
            if (views.containsKey(videoId)) {
                return Optional.of(views.get(videoId));
            }
            return Optional.empty();
        }
    }
}
