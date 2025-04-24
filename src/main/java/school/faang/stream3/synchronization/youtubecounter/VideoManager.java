package school.faang.stream3.synchronization.youtubecounter;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class VideoManager {
    private final Object lock = new Object();
    private Map<String, Integer> viewsMap = new HashMap<>();

    public void addVideo(String videoId) {
        synchronized (lock) {
            viewsMap.put(videoId, 0);
        }
    }

    public void addView(String videoId) {
        synchronized (lock) {
            Integer count = viewsMap.get(videoId);
            viewsMap.put(videoId, ++count);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (lock) {
            if (viewsMap.containsKey(videoId)) {
                return viewsMap.get(videoId);
            } else {
                throw new NoSuchElementException("Video ID not found: " + videoId);
            }
        }
    }
}
