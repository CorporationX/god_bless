package faang.school.godbless.BJS2_3250;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Object viewLock = new Object();
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewLock) {
            if (viewsMap.containsKey(videoId)) {
                viewsMap.put(videoId, viewsMap.get(videoId) + 1);
            } else {
                throw new IllegalArgumentException("videoId");
            }
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewLock) {
            if (viewsMap.containsKey(videoId)) {
                return viewsMap.get(videoId);
            } else {
                throw new IllegalArgumentException("videoId");
            }
        }
    }

    public void addVideo(String videoId) {
        synchronized (viewsMap) {
            viewsMap.put(videoId, 0);
        }
    }

}