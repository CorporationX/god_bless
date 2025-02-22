package school.faang.bjs2_61623;

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

        for (int videoIndex = 1; videoIndex <= NUM_VIDEOS; videoIndex++) {
            String videoId = "Video_" + videoIndex;
            for (int threadIndex = 0; threadIndex < NUM_THREADS; threadIndex++) {
                executor.submit(() -> videoManager.addView(videoId));
            }
        }

        try {
            executor.shutdown();
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        for (int videoIndex = 1; videoIndex <= NUM_VIDEOS; videoIndex++) {
            String videoId = "Video_" + videoIndex;
            log.info("Final view count for {}: {}", videoId, videoManager.getViewCount(videoId));
        }
    }
}
