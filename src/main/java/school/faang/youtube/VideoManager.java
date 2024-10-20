package school.faang.youtube;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class VideoManager {

    private final ConcurrentHashMap<String, AtomicInteger> viewsMap;

    public VideoManager() {
        this.viewsMap = new ConcurrentHashMap<>();
    }


    public void addView(String videoId) {
        viewsMap.computeIfAbsent(videoId, k -> new AtomicInteger(0)).incrementAndGet();
    }

    public int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, new AtomicInteger(0)).get();
    }
}
