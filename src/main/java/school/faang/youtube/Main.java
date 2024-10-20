package school.faang.youtube;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Log4j2
public class Main {
    public static final int NUM_THREADS = 100;
    public static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {


        VideoManager videoManager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            final String videoId = "Video " + i;
            int taskPerVideo = NUM_THREADS / NUM_VIDEOS;
            for (int j = 0; j < taskPerVideo; j++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Video " + videoId + " views: " + videoManager.getViewCount(videoId));
                });
            }
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(300, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread" + Thread.currentThread().getName() + "was interrupted", e);
            executor.shutdownNow();
        }

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "Video " + i;
            System.out.println("Final views for " + videoId + ": " + videoManager.getViewCount(videoId));
        }
    }
}
