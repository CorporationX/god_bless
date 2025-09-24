package school.faang.bjs2_90190;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_THREADS; j++) {
                int finalI = i;
                executorService.execute(() -> videoManager.addView("Video" + finalI));
            }
        }
        executorService.shutdown();
        if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
        for (int i = 0; i < NUM_VIDEOS; i++) {
            System.out.printf("Video%d has %d view(s)\n", i, videoManager.getViewCount("Video" + i));
        }

    }
}
