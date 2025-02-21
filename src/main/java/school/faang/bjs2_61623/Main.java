package school.faang.bjs2_61623;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "Video_" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> videoManager.addView(videoId));
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "Video_" + i;
            log.info("Final view count for {}: {}", videoId, videoManager.getViewCount(videoId));
        }
    }
}
