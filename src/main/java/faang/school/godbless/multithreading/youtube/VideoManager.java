package faang.school.godbless.multithreading.youtube;

import java.util.Map;
import java.util.HashMap;

public class VideoManager {

    private final Object lockAdd = new Object();
    private static final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (lockAdd) {
            if (viewsMap.containsKey(videoId)) {
                viewsMap.put(videoId, viewsMap.get(videoId) + 1);
            } else {
                viewsMap.put(videoId, 1);
            }
        }
    }

    public int getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }
}
