package school.faang.bjs2_61623;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class VideoManager {
    private final ConcurrentHashMap<String, AtomicInteger> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsMap.computeIfAbsent(videoId, k -> new AtomicInteger(0)).incrementAndGet();
        log.info("View added for video: {}", videoId);
    }

    public int getViewCount(String videoId) {
        return Optional.ofNullable(viewsMap.get(videoId)).map(AtomicInteger::get).orElse(0);
    }
}
