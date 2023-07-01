package youtoube_views_count;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();

        int NUM_TREADS = 100;
        int NUM_VIDEOS = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_TREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;

            for (int j = 0; j < NUM_TREADS / NUM_VIDEOS; j++) {
                executorService.execute(() -> {
                    String threadName = Thread.currentThread().getName();
                    videoManager.addView(videoId);
                    System.out.println("Thread: " + threadName + ", Count views for " + videoId + ": " + videoManager.getViewCount(videoId));
                });
            }
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
    }
}
