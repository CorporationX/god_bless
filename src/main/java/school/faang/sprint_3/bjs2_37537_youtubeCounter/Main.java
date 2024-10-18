package school.faang.sprint_3.bjs2_37537_youtubeCounter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int THREADS_COUNT = 100;
    public static final int VIDEOS_COUNT = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        for (int i = 1; i <= VIDEOS_COUNT; i++) {
            String videoId = "video" + i;
            for (int j = 0; j < THREADS_COUNT; j++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    log.info("Video '{}' has {} views", videoId, videoManager.getViewCount(videoId));
                });
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    log.error("An error occurred while adding the view and getting views count", e);
                    throw new RuntimeException(e);
                }
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("An error occurred while waiting for the threads to complete.", e);
            throw new RuntimeException(e);
        }
    }
}
