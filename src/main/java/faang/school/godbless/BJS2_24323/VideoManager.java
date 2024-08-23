package faang.school.godbless.BJS2_24323;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {

    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoID) {
        synchronized (viewsMap) {
            int views = viewsMap.getOrDefault(videoID, 0) + 1;
            viewsMap.put(videoID, views);
        }
    }

    public int getViewCount(String videoID) {
        synchronized (viewsMap) {
            return viewsMap.getOrDefault(videoID, 0);
        }
    }
}
