package school.faang.bjs2_81739;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Application {

    private static final int NUM_THREADS = 20;
    private static final int NUM_VIDEOS = 5;
    private static final int VIEWS_PER_VIDEO = 1000;

    public static void main(String[] args) throws InterruptedException {
        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        log.info("Submitting tasks...");

        for (int videoIndex = 1; videoIndex <= NUM_VIDEOS; videoIndex++) {
            String videoId = "video" + videoIndex;
            String finalVideoId = videoId;

            for (int i = 0; i < VIEWS_PER_VIDEO; i++) {
                executor.execute(() -> manager.addView(finalVideoId));
            }
        }

        executor.shutdown();
        log.info("Waiting for tasks to complete...");
        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            executor.shutdownNow();
            log.warn("Force shutdown initiated.");
        }

        log.info("Final view counts:");
        for (int videoIndex = 1; videoIndex <= NUM_VIDEOS; videoIndex++) {
            String videoId = "video" + videoIndex;
            int views = manager.getViewCount(videoId);
            log.info("{} has {} views.", videoId, views);
        }
    }
}
