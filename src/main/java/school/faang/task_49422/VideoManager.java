package school.faang.task_49422;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {

    public static final int VIEW_INCREMENT = 1;

    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsMap.merge(videoId, VIEW_INCREMENT, Integer::sum);
    }

    public int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}