package school.faang.youtube;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Danil Pudovkin
 * @since 18.06.2025
 */
public class VideoManager {

    private final Map<String, AtomicInteger> viewsCount = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsCount.computeIfAbsent(videoId, v -> new AtomicInteger(0))
                .incrementAndGet();
    }

    public int getViewCount(String videoId) {
        return viewsCount.get(videoId).get();
    }
}
