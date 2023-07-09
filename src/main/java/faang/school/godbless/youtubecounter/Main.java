package faang.school.godbless.youtubecounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 200;
    private static final int NUM_VIDEOS = 100;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i <= NUM_VIDEOS; i++) {
            videoManager.getViewsMap().put(Integer.toString(i), 0);
        }
        for (int i = 0; i <= NUM_VIDEOS; i++) {
            int finalI = i;
            for (int j = 1; j <= NUM_THREADS/NUM_VIDEOS; j++) {
                executor.submit(() -> videoManager.addView(Integer.toString(finalI)));
            }
        }
        executor.shutdown();
        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
