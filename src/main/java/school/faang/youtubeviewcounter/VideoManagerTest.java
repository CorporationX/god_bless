package school.faang.youtubeviewcounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VideoManagerTest {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video_" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    int viewCount = videoManager.getViewCount(videoId);
                    System.out.println("Video: " + videoId + ", Current Views: " + viewCount);
                });
            }
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow(); // Force shutdown if tasks are not completed within 1 minute
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
