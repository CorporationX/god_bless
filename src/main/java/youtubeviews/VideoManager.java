package youtubeviews;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VideoManager {
    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();
    private static final int NUM_VIDEOS = 5;
    private static final int AWAIT_TERMINATION = 60;
    private static final int SLEEP_MILLIS = 150;

    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsMap.compute(videoId, (key, value) -> {
            int newCount = (value == null) ? 1 : value + 1;
            log.info("[{}] {} now has {} views", Thread.currentThread().getName(), videoId, newCount);
            return newCount;
        });

        try {
            Thread.sleep(SLEEP_MILLIS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("[{}] Thread interrupted while sleeping", Thread.currentThread().getName(), e);
        }
    }

    public int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int videoNumber = 1; videoNumber <= NUM_VIDEOS; videoNumber++) {
            final String videoId = "Video " + videoNumber;
            for (int threadNumber = 0; threadNumber < NUM_THREADS; threadNumber++) {
                executorService.submit(() -> videoManager.addView(videoId));
            }
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION, TimeUnit.SECONDS)) {
                log.warn("Forcing shutdown due to timeout...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread interrupted while waiting for termination", e);
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        for (int videoNumber = 1; videoNumber <= NUM_VIDEOS; videoNumber++) {
            String videoId = "Video " + videoNumber;
            log.info("Current view count for {}: {}", videoId, videoManager.getViewCount(videoId));
        }
    }
}
