package faang.school.godbless.BJS2_24387;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
@Getter
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        }
    }

    public synchronized int getViewCount(String videoId) {
        synchronized (viewsMap) {
            return viewsMap.get(videoId);
        }
    }
}
