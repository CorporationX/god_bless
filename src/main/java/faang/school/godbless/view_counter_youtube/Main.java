package faang.school.godbless.view_counter_youtube;

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
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                String videoId = String.valueOf(i);

                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    int currentVideoViews = videoManager.getViewCount(videoId);
                    System.out.printf("%s: added view for videoId: %s, total count: %d\n", Thread.currentThread().getName(), videoId, currentVideoViews);
                });
            }
        }
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Result: " + videoManager.getViewsMap());
        executorService.shutdown();
    }
}
