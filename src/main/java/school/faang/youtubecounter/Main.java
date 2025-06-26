package school.faang.youtubecounter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int NUM_THREADS = 5;
    public static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService videoManagersExecutor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                videoManagersExecutor.submit(() -> {
                    videoManager.addView(videoId);
                    log.info("Thread {} viewed {}, total = {}",
                            Thread.currentThread().getName(),
                            videoId,
                            videoManager.getViewCount(videoId));
                });
            }
        }

        log.info("Initiating shutdown");
        videoManagersExecutor.shutdown();
        try {
            if (!videoManagersExecutor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.warn("Timeout — forcing shutdown");
                videoManagersExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Shutdown interrupted, forcing stop", e);
            videoManagersExecutor.shutdownNow();
        }
    }

}
