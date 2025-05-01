package school.faang.bjs2_73906;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final String VIDEO = "video";
    public static final int NUM_THREADS = 5;
    public static final int NUM_VIDEOS = 10;
    public static final int AWAIT_TIMEOUT_MINUTES = 2;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_THREADS; j++) {
                String videoId = VIDEO + i;
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    log.info("The count of video's view with id = {} is {}", videoId,
                            videoManager.getViewCount(videoId));
                });
            }
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                log.warn("Timeout: videos view counting was not completed within the allotted time");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("The thread was interrupted while waiting for completion videos view " +
                    "counting", e);
        }
    }
}
