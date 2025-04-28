package school.faang.youtubecounter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();
    Lock lock = new ReentrantLock();

    public void addView(String videoId) {
        lock.lock();
        try {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        } finally {
            lock.unlock();
        }
    }

    public int getViewCount(String videoId) {
        lock.lock();
        try {
            return viewsMap.getOrDefault(videoId, 0);
        } finally {
            lock.unlock();
        }
    }
}