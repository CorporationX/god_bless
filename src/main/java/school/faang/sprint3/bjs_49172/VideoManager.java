package school.faang.sprint3.bjs_49172;

import lombok.NonNull;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoManager {
    private final ConcurrentHashMap<String, AtomicInteger> viewsMap = new ConcurrentHashMap<>();

    public synchronized void addView(@NonNull String videoId) {
        viewsMap.computeIfAbsent(videoId, id -> new AtomicInteger(0)).incrementAndGet();
    }

    public synchronized int getViewCount(@NonNull String videoId) {
        return viewsMap.getOrDefault(videoId, new AtomicInteger(0)).get();
    }
}
