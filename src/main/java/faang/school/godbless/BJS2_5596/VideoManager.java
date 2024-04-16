package faang.school.godbless.BJS2_5596;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class VideoManager {
    private Map<String, Integer> viewMap = new HashMap<>();
    private int viewsMap;

    public synchronized void addView(String videoId) {
        viewMap.put(videoId, viewMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized int getViewCount(String videoId) {
        return viewMap.getOrDefault(videoId, 0);
    }
}
