package school.faang.module3.youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_VIDEOS = 10;
    private static final int NUM_THREADS = 3;
    private static final int TIMEOUT = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int v = 0; v < NUM_VIDEOS; v++) {
            String videoId = String.valueOf(v);
            for (int t = 0; t < NUM_THREADS; t++) {
                executorService.submit(() -> videoManager.addView(videoId));
            }
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        for (int v = 0; v < NUM_VIDEOS; v++) {
            String videoId = String.valueOf(v);
            log.info("Видео {} просмотров: {}", videoId, videoManager.getViewCount(videoId));
        }

    }
}
