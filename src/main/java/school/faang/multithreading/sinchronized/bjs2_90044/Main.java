package school.faang.multithreading.sinchronized.bjs2_90044;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 4;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "Video" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> videoManager.addView(videoId));
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
