package faang.school.godbless.module.third.synchronization.youtube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> VIEWS_MAP = new HashMap<>();
    
    public void addView(String videoId) {
        synchronized (VIEWS_MAP) {
            VIEWS_MAP.compute(videoId, (key, value) -> value == null ? 1 : value + 1);
        }
    }
    
    public int getViewCount(String videoId) {
        synchronized (VIEWS_MAP) {
            return VIEWS_MAP.get(videoId);
        }
    }
    
    public void addVideo(String videoId) {
        VIEWS_MAP.put(videoId, 0);
    }
}
