package school.faang.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL = 5;
    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);
        VideoManager videoManager = new VideoManager();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            videoManager.addView(String.valueOf(i));
        }

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = String.valueOf(i);
            for (int j = 0; j < NUM_THREADS; j++) {
                executorService.submit(() -> videoManager.addView(videoId));
            }
        }

        executorService.shutdown();
        if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
            System.out.println("Time is out.");
        }

        System.out.println("Views:");
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = String.valueOf(i);
            System.out.println("Video " + videoId + ": " + videoManager.getViewCount(videoId));
        }
    }
}
