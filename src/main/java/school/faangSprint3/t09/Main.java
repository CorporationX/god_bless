package school.faangSprint3.t09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;

        VideoManager manager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    manager.addView(videoId);
                    int viewCount = manager.getViewCount(videoId);
                    System.out.println("Video " + videoId + " views: " + viewCount);
                });
            }
        }

        executor.shutdown();
        if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
            System.err.println("Tasks did not complete within 1 minute");
        }

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            System.out.println("Final count for " + videoId + ": " + manager.getViewCount(videoId));
        }
    }
}