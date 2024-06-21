package faang.school.godbless.youTubeViewCounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 25;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            videoManager.getViewsMap().put(i, 0);
        }

        for (Integer videoId : videoManager.getViewsMap().keySet()) {
            for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Count views on video " +
                            videoId + " : " + videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();

        try {
            executor.awaitTermination(20, TimeUnit.SECONDS);
            executor.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Complete");
    }
}
