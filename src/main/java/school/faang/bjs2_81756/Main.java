package school.faang.bjs2_81756;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 100;
    private static final int TIME_AWAIT_TERMINATOR = 10;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager videoManager = new VideoManager();

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            int videoId = i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> videoManager.addView(String.valueOf(videoId)));
            }
            executor.submit(() -> System.out.printf(
                    "Id: %s, Views: %s%n",
                    videoId,
                    videoManager.getViewCount(String.valueOf(videoId)))
            );
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIME_AWAIT_TERMINATOR, TIME_UNIT)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
}
