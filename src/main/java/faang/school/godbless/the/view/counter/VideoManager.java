package faang.school.godbless.the.view.counter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<Integer, Integer> viewsMap;

    public VideoManager(Map<Integer, Integer> viewsMap) {
        this.viewsMap = viewsMap;
    }

    public synchronized void addView(int videoId) {
        if(!viewsMap.containsKey(videoId)) {
            throw new RuntimeException("We couldn't find video with id: " + videoId);
        }
        viewsMap.replace(videoId, viewsMap.get(videoId) + 1);
    }

    public synchronized int getViewCount(int videoId) {
        if(!viewsMap.containsKey(videoId)) {
            throw new RuntimeException("We couldn't find video with id: " + videoId);
        }
        return viewsMap.get(videoId);
    }
}
