package faang.school.godbless.youtube_views;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 20;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);
    private static final VideoManager VIDEO_MANAGER = new VideoManager();
    public static void main(String[] args) {
        for (int i = 0; i < NUM_VIDEOS; i++) {
            VIDEO_MANAGER.getViewsMap().put(String.valueOf(i), i);
        }

        int videoID = 0;
        for (int i = 0; i < NUM_THREADS/NUM_VIDEOS; i++) {
            watchVideo(String.valueOf(videoID));
        }
        videoID++;
        EXECUTOR.shutdown();

        try {
            EXECUTOR.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void watchVideo (String videoID) {
        EXECUTOR.submit(() -> VIDEO_MANAGER.addView(videoID));
    }
}
