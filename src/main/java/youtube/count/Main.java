package youtube.count;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 4;
    private static final int NUM_VIDEOS = 10;
    private static final int TIMEOUT = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = String.valueOf(i);
            for (int j = 0; j < NUM_THREADS; j++) {
                executorService.submit(() -> videoManager.addViews(videoId));
                executorService.submit(() -> videoManager.getViewCount(videoId));
            }
        }

        softShutdown(executorService);
    }

    private static void softShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Execution is not terminated in time. Forced shutdown!");
                executor.shutdownNow();
            } else {
                log.info("Execution is terminated successful!");
            }
        } catch (InterruptedException e) {
            log.error("Executor is interrupted {}", e.getMessage());
            executor.shutdownNow();
        }
    }
}

