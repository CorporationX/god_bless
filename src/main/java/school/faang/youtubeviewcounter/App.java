package school.faang.youtubeviewcounter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class App {
    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;

            for (int j = 0; j < NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    manager.addView(videoId);
                    log.info("Video: {}, view count: {}",
                            videoId, manager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
                log.info("Поток завершен");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.info("Поток прерван принудительно");
        }
    }
}
