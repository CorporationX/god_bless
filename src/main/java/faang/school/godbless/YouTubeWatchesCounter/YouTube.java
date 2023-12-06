package faang.school.godbless.YouTubeWatchesCounter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class YouTube {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = String.valueOf(System.currentTimeMillis() / i);
            videoManager.addVideo(videoId);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Video ID: " + videoId +
                            " | Views: " + videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();
        if (executor.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
            System.out.println("Counting finished");
        }


    }
}
