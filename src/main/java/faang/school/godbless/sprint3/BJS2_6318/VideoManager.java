package faang.school.godbless.sprint3.BJS2_6318;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();
    private final Map<String, Object> lockMap = new HashMap<>();

    private Object getLock(String videoId) {
        synchronized (lockMap) {
            return lockMap.computeIfAbsent(videoId, k -> new Object());
        }
    }

    public void addView(String videoId) {
        synchronized (getLock(videoId)) {
            Integer currentCount = viewsMap.getOrDefault(videoId, 0);
            viewsMap.put(videoId, currentCount + 1);
        }
    }

    public synchronized int getViewCount(String videoId) {
        synchronized (getLock(videoId)) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }
}
