package sprint4.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class YouTube {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final ExecutorService SERVICE = Executors.newFixedThreadPool(NUM_THREADS);
    private static final VideoManager VIDEO_MANAGER = new VideoManager();

    public static void main(String[] args) {

        for (int i = 0; i < NUM_VIDEOS; i++) {
            VIDEO_MANAGER.getViewsMap().put(String.valueOf(i), 0);
        }

        int videoId = 0;
        for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
            goWatchVideo(String.valueOf(videoId));
            videoId++;
        }
        SERVICE.shutdown();

        try {
            SERVICE.awaitTermination(3, TimeUnit.SECONDS);
            SERVICE.shutdownNow();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void goWatchVideo(String videoId) {
        for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
            SERVICE.execute(() -> VIDEO_MANAGER.addView(videoId));
        }
    }
}
