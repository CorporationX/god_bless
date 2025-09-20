package school.faang.bjs2_90026;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VideoManager {
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 5;

    private final ConcurrentHashMap<String, Integer> viewsMap = new ConcurrentHashMap<>();


    public synchronized void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

    public static void main(String[] args) {

        VideoManager manager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int videoIndex = 1; videoIndex <= NUM_VIDEOS; videoIndex++) {
            String videoId = "video" + videoIndex;

            for (int i = 0; i < NUM_THREADS; i++) {
                executor.submit(() -> {
                    manager.addView(videoId);
                });
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        for (int videoIndex = 1; videoIndex <= NUM_VIDEOS; videoIndex++) {
            String videoId = "video" + videoIndex;
            log.info("{} views: {}", videoId, manager.getViewCount(videoId));
        }
    }
}
