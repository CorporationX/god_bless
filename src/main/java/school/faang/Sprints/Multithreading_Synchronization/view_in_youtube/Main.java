package school.faang.Sprints.Multithreading_Synchronization.view_in_youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        int NUM_THREADS = 100;
        int NUM_VIDEOS = 10;
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    manager.addView(videoId);
                    System.out.println(Thread.currentThread().getName()+ " Video " + videoId + " views: " + manager.getViewCount(videoId));
                });
            }
        }
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}