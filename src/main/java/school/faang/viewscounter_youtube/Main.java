package school.faang.viewscounter_youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager videoManager = new VideoManager();

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            videoManager.addNewVideo("Video " + i);
        }
        videoManager.getViewsMap().forEach((video, views) -> {
            for (int i = 1; i <= NUM_THREADS / NUM_VIDEOS; i++) {
                executor.submit(() -> {
                    videoManager.addView(video);
                    System.out.println(video + " has " + videoManager.getViewCount(video) + " views");
                });
            }
        });
        executor.shutdown();
        if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Mission complete");
        } else {
            System.out.println("Something went wrong..");
        }
    }
}
