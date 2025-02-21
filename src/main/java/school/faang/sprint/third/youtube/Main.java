package school.faang.sprint.third.youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 10;
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = UUID.randomUUID().toString();
            for (int j = 0; j < NUM_THREADS; j++) {
                executorService.submit(() -> videoManager.addView(videoId));
                executorService.submit(() -> log.info("View for vied: {} is {}", videoId, videoManager.getViewCount(videoId)));
            }
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
