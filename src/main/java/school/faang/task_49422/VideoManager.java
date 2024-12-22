package school.faang.task_49422;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {

    public static final int INCREASE_IN_NUMBER_OF_VIEWS_BY = 1;

    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + INCREASE_IN_NUMBER_OF_VIEWS_BY);
    }

    public int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}