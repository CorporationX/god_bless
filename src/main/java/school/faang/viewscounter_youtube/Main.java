package school.faang.viewscounter_youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int numThreads = 100;
        final int numVideos = 10;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        VideoManager videoManager = new VideoManager();

        for (int i = 1; i <= numVideos; i++) {
            videoManager.addNewVideo("Video " + i);
        }
        videoManager.getViewsMap().forEach((video, views) -> {
            for (int i = 1; i <= numThreads / numVideos; i++) {
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
