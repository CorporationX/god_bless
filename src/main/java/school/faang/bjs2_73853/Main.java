package school.faang.bjs2_73853;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final int TERMINATION_TIMEOUT = 10;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        for (int i = 0; i < NUM_THREADS; i++) {
            final int iterator = i;
            executorService.execute(() -> {
                for (int j = 0; j < NUM_VIDEOS; j++) {
                    String videoId = "Video%d".formatted(iterator);
                    videoManager.addView(videoId);
                    log.info("Video: {}, Views: {}", videoId, videoManager.getViewCount(videoId));
                }
            });
        }

        dispose();
    }

    private static void dispose() {
        log.info("Start disposing executor service");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Not all tasks was stopped successfully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted exception with message {} was thrown", e.getMessage());
            executorService.shutdownNow();
        }
    }
}