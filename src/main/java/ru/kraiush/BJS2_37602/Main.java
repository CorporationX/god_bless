package ru.kraiush.BJS2_37602;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; ++i) {
            String videoId = String.valueOf(i);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; ++j) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    videoManager.getViewCount(videoId);
                });
            }
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
