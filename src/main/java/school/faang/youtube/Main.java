package school.faang.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    static final int NUM_THREADS = 3;
    static final int NUM_VIDEOS = 500000000;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String name = "Video" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executorService.submit(
                        () -> videoManager.addView(name)
                );
            }
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ignored) {
            executorService.shutdownNow();
            throw new RuntimeException(ignored.getMessage());
        }
    }
}
