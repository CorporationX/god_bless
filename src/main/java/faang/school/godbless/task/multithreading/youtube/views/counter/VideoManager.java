package faang.school.godbless.task.multithreading.youtube.views.counter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VideoManager {
    private final Map<String, Long> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.merge(videoId, 1L, Long::sum);
    }

    public synchronized Optional<Long> getViewCount(String videoId) {
        return Optional.ofNullable(viewsMap.get(videoId));
    }
}
