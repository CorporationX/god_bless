package school.faang.viewscounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 3;
    private static final int NUM_VIDEO = 2;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEO; i++) {
            String videoId = "video" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> {
                    manager.addView(videoId);
                    System.out.printf("\nVideo: %s, просмотров: %d", videoId, manager.getViewCount(videoId));
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
            Thread.currentThread().interrupt();
        }
    }
}
