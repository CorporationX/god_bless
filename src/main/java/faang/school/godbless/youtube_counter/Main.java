package faang.school.godbless.youtube_counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int NUM_THREADS = 100;
        int NUM_VIDEOS = 5;

        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            videoManager.getViewsMap().put(i, 0);
            int videoId = i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Add views to video " + videoId);
                    System.out.println("Video " + videoId + " has " + videoManager.getViewCount(videoId) + " views");
                });
            }
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nFinal results:");
        for (int i = 0; i < NUM_VIDEOS; i++) {
            System.out.println("Video " + i + " has " + videoManager.getViewsMap().get(i) + " views");
        }
    }
}
