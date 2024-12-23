package school.faang.sprint3.task_49223;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int numThreads = 100;
        final int numVideos = 10;

        VideoManager manager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numVideos; i++) {
            String videoId = "video" + i;

            for (int j = 0; j < numThreads / numVideos; j++) {
                executor.submit(() -> {
                    manager.addView(videoId);
                    System.out.println("Video " + videoId + " просмотров: " + manager.getViewCount(videoId));
                });
            }
        }

        executor.awaitTermination(3, TimeUnit.SECONDS);
        executor.shutdown();

        manager.getAllVideo();
    }
}

