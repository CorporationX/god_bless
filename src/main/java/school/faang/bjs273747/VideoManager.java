package school.faang.bjs273747;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
        System.out.printf("Video added: %s (%s)\n", videoId, Thread.currentThread().getName());
    }

    public synchronized int getView(String videoId) {
        return viewsMap.get(videoId);
    }
}