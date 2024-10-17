package school.faang.youtube_view_couner_BJS2_37485;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int NUM_THREADS = 25;
        final int NUM_VIDEOS = 7;
        final int AWAITING_TIME = 3;

        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "Video" + i;

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.printf("Count of views for video - %s: %d\n", videoId, videoManager.getViewCount(videoId));
                });
            }
        }
        executorService.shutdown();

        if (executorService.awaitTermination(AWAITING_TIME, TimeUnit.SECONDS)) {
            System.out.println("All actions was executed successfully");
        }
        System.out.println("Time is over ,execution stopped");
        executorService.shutdownNow();
    }
}
