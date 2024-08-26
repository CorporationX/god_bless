package faang.school.godbless.bjs224458;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int numThreads = 100;
        int numVideos = 5;
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        for (int i = 1; i <= 5; i++) {
            String videoId = "video_" + i;
            videoManager.addVideo(videoId);
            for (int j = 0; j < numThreads / numVideos; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    System.out.println(videoId + ": " + videoManager.getViewCount(videoId) + " views");
                });
            }
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
