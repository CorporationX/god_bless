package youTubeViewCounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String idFormat = "%d".formatted(i);
            videoManager.addView(idFormat);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    videoManager.addView(idFormat);
                    System.out.println(videoManager.getViewCount(idFormat));
                });
            }
        }

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.MINUTES);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String idFormat = "%d".formatted(i);
            System.out.println(videoManager.getViewCount(idFormat));
        }

    }
}
