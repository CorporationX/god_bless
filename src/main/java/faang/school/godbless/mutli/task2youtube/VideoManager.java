package faang.school.godbless.mutli.task2youtube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
