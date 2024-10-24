package school.faang_sprint_3.youtube_views_counter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        var manager = new VideoManager();

        var threadPool = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video-" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                threadPool.submit(() ->
                        manager.addView(videoId));
                log.info("Video: {} views: {}", videoId, manager.getViewCount(videoId));
            }
        }
        threadPool.shutdown();

        try {
            if (!threadPool.awaitTermination(1, TimeUnit.MINUTES)) {
                threadPool.shutdownNow();
                log.error("TimeOut. All threads have been terminated");
            } else {
                log.info("All threads have been finished");
            }
        } catch (InterruptedException e) {
            log.error("Main thread interrupted", e);
            throw new IllegalStateException("Main thread interrupted: " + e.getMessage());
        }
    }

}
