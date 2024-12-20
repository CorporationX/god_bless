package school.faang.task_49123;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "Video №" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    log.info("The number of views on the video {}: {}", videoId, videoManager.getViewCount(videoId));
                });
            }
        }

        executorService.shutdown();
        if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            log.info("Processing of the number of page views is completed correctly");
        } else {
            executorService.shutdownNow();
        }
    }
}
