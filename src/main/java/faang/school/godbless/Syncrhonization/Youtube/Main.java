package faang.school.godbless.Syncrhonization.Youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 7;

        ExecutorService executor = Executors.newFixedThreadPool(NUM_VIDEOS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            ExecutorService videoExecutor = Executors.newSingleThreadExecutor();
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                videoExecutor.submit(() -> {
                    videoManager.addView(videoId);
                    int views = videoManager.getViewCount(videoId);
                    System.out.println("Video: " + videoId + ", Views: " + views);
                });
            }
            videoExecutor.shutdown();
        }

        executor.shutdown();

        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
            System.out.println("All threads finished work");
        } catch (InterruptedException e) {
            System.err.println("Something went wrong at counting process: " + e.getMessage());
        }
    }
}
