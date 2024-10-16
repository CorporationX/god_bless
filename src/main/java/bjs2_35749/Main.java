package bjs2_35749;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager videoManager = new VideoManager();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = Integer.toString(i);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> videoManager.addView(videoId));
            }
        }

        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.SECONDS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = Integer.toString(i);
            int videoViewCount = videoManager.getViewCount(videoId);
            System.out.printf("VideoId: %s. View count: %d\n", videoId,videoViewCount);
        }
    }
}
