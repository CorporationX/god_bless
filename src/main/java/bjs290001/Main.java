package bjs290001;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int NUM_THREADS = 10;
    public static final int NUM_VIDEOS = 50;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "Video " + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.printf(" %s has %d views. \n", videoId, videoManager.getViewCount(videoId));
                });
            }
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
