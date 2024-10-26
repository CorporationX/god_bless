package school.faang.synchronizedthreads2;

import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private final ConcurrentHashMap<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
