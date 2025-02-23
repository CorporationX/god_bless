package school.faang.task_61739;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();
    private final ReentrantLock lock = new ReentrantLock();


    public void addView(String videoId) {
        lock.lock();
        try {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
            log.info(videoId + " просмотрели");
        } finally {
            lock.unlock();
        }

    }

    public int getViewCount(String videoId) {
        lock.lock();
        int count = 0;
        try {
            count = viewsMap.getOrDefault(videoId, 0);
        } finally {
            lock.unlock();
        }
        return count;
    }
}
