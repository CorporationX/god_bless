package school.faang.task_49205;

import lombok.NonNull;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoManager {
    private final ConcurrentMap<String, AtomicInteger> viewsMap;

    public VideoManager() {
        this.viewsMap = new ConcurrentHashMap<>();
    }

    public void addView(@NonNull String videoId) {
        viewsMap.computeIfAbsent(videoId, key -> new AtomicInteger(0)).incrementAndGet();
    }

    public int getViewCount(@NonNull String videoId) {
        return viewsMap.getOrDefault(videoId, new AtomicInteger(0)).get();
    }

}
