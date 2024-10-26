package school.faang.youtubecounter;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoManager {
    ConcurrentHashMap<String, Integer> viewsMap = new ConcurrentHashMap<>();
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, atomicInteger.incrementAndGet());
    }

    public synchronized Integer getViewCount(String videoId) {
        Integer num = 0;
        for (Map.Entry<String, Integer> entry : viewsMap.entrySet()) {
            if (entry.getKey().equals(videoId)) {
                num = entry.getValue();
            }
        }
        return num;
    }
}
