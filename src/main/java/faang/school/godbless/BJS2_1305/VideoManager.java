package faang.school.godbless.BJS2_1305;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, -1);
    }

}
