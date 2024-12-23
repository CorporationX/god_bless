package school.faang.task_49198;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.compute(videoId, (k, v) -> (v == null ? 1 : v + 1));
    }

    public synchronized Integer getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

    public void showTotalNumberVideoViews() {
        System.out.println(viewsMap.toString());
    }
}
