package school.faang.bjs2_81750;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    static final int NUM_THREADS = 15;
    static final int NUM_VIDEOS = 7;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_THREADS; j++) {
                String videoId = "/video" + i;
                executorService.execute(() -> videoManager.addView(videoId));
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
