package school.faang.youtube_view_counter.BJS2_61656;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    LOGGER.info("На видео {}, {} просмотров.", videoId, videoManager.getViewCount(videoId));
                });
            }
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
