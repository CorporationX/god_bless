package school.faang.youtubeviewcounter;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();
    public final Set<Listener> listeners = new HashSet<>();
    private final Object lock = new Object();

    public void addView(String videoId) {
        int newCount;
        synchronized (lock) {
            if (videoId == null || videoId.isEmpty()) {
                throw new IllegalArgumentException("videoId must not be null or empty!");
            }
            newCount = viewsMap.compute(videoId, (k, v) -> v == null ? 1 : v + 1);
        }
        synchronized (listeners) {
            listeners.forEach(l -> l.onViewCountChanged(videoId, newCount));
        }
    }

    public int getViewCount(String videoId) {
        synchronized (lock) {
            if (!viewsMap.containsKey(videoId)) {
                throw new IllegalArgumentException(String.format("This video %s is not in the viewsMap!", videoId));
            }
            return viewsMap.get(videoId);
        }
    }

    public void addListener(Listener listener) {
        synchronized (listeners) {
            listeners.add(listener);
        }
    }
}
