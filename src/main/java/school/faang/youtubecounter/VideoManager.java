package school.faang.youtubecounter;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap;
    private final ReentrantLock lock;

    public VideoManager() {
        viewsMap = new HashMap<>();
        lock = new ReentrantLock();
    }

    public void addView(@NonNull String videoId) {
        lock.lock();
        try {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        } finally {
            lock.unlock();
        }
    }

    public int getViewCount(@NonNull String videoId) {
        lock.lock();
        try {
            return viewsMap.getOrDefault(videoId, 0);
        } finally {
            lock.unlock();
        }
    }
}
