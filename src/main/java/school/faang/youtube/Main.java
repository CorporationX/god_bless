package school.faang.youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 10;
    private static final int TIMEOUT = 60;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "video_" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.execute(() -> manager.addView(videoId));
            }
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "video_" + i;
            log.info("Видео {}  просмотров: {}", videoId, manager.getViewCount(videoId));
        }
    }
}
