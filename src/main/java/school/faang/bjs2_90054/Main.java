package school.faang.bjs2_90054;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final int AWAIT_TERMINATION_MIN = 1;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video_" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    log.info("Видео {} просмотров {}", videoId, videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_MIN, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
