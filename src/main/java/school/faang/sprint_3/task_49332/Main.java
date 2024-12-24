package school.faang.sprint_3.task_49332;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10000;
    private static final int NUM_VIDEOS = 10;
    private static final int AWAIT_TIME_MINUTES = 1;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        try {
            for (int i = 1; i <= NUM_VIDEOS; i++) {
                String videoId = "video " + i;
                for (int j = 0; j <= NUM_THREADS / NUM_VIDEOS; j++) {
                    executor.submit(() -> videoManager.addView(videoId));
                    log.info("Video {} views: {}", videoId, videoManager.getViewCount(videoId));
                }
            }
            executor.shutdown();
            if (executor.awaitTermination(AWAIT_TIME_MINUTES, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (Exception e) {
            log.error("Error message: ", e);
        }
    }
}
