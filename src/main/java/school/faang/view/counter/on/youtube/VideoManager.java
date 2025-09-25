package school.faang.view.counter.on.youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class VideoManager {
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 5;
    private static final int TIME_FOR_WAITING = 1;

    private final ConcurrentHashMap<String, AtomicInteger> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsMap.computeIfAbsent(videoId, k -> new AtomicInteger()).incrementAndGet();
    }

    public int getViewCount(String videoId) {
        AtomicInteger counter = viewsMap.get(videoId);
        return counter != null ? counter.get() : 0;
    }

    /**
     * Атомарно добавляет просмотр и возвращает обновленное количество
     *
     * @param videoId идентификатор видео
     * @return количество просмотров после добавления
     */

    public int addViewAndGetCount(String videoId) {
        return viewsMap.computeIfAbsent(videoId, k -> new AtomicInteger())
                .incrementAndGet();
    }

    private static void shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_FOR_WAITING, TimeUnit.MINUTES)) {
                log.warn("Executor did not terminate in time, forcing shutdown");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Executor shutdown interrupted", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt(); // Восстанавливаем статус прерывания
        }
    }

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> {
                    int newCount = videoManager.addViewAndGetCount(videoId);
                    log.info("Video {} views: {}", videoId, newCount);
                });
            }
        }

        shutdownExecutor(executor);
    }
}
