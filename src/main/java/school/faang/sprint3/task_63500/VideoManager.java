package school.faang.sprint3.task_63500;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class VideoManager {
    private final Map<String, AtomicLong> viewsMap = new HashMap<>();
    private final ReentrantLock lock = new ReentrantLock();
    private long viewCount;

    public void addView(String videoId) {
        lock.lock();
        try {
            viewsMap.computeIfAbsent(videoId, v -> new AtomicLong());
            viewCount = viewsMap.get(videoId).incrementAndGet();
            log.debug("К {} добавили просмотр", videoId);
        } finally {
            lock.unlock();
        }
    }

    public long getViewCount(String videoId) {
        lock.lock();
        try {
            if (viewsMap.containsKey(videoId)) {
                throw new IllegalArgumentException("Такого видео не существует " + videoId);
            }

            viewCount = viewsMap.get(videoId).get();
            log.debug("{} посмотрели {} раз, ", videoId, viewCount);
            return viewCount;
        } finally {
            lock.unlock();
        }
    }

    public long getAllViewCount() {
        return viewsMap.values().stream()
                .map(AtomicLong::get)
                .reduce(0L, Long::sum);
    }
}
