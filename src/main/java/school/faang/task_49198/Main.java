package school.faang.task_49198;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            int indxVideo = i;
            String videoId = String.format("Video_%d", indxVideo);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(() -> videoManager.addView(videoId));
                executor.submit(() -> {
                    System.out.println(String.format("Video %s has %d views.", videoId,
                            videoManager.getViewCount(videoId)));
                });
            }

        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        videoManager.showTotalNumberVideoViews();
    }
}