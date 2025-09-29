package school.faang.bjs2_90122;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int NUM_THREADS = 4;
    private static final int NUM_OF_VIDEOS = 10;

    public static void main(String[] args) {

        VideoManager manager = new VideoManager();
        ExecutorService exec = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_OF_VIDEOS; i++) {
            String videoId = "video " + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                exec.submit(() -> {
                    manager.addView(videoId);
                    manager.getViewCount(videoId);
                });
            }
        }

        exec.shutdown();
        try {
            if (!exec.awaitTermination(1, TimeUnit.MINUTES)) {
                log.warn("Timeout reached, shutting down.");
                exec.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Code execution encountered an error: " + e);
        }
        exec.shutdownNow();
    }
}
