package mod1sp3.youtubeViewCounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int NUM_THREADS = 100;
    private final static int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String video = "video " + (i + 1);
            videoManager.getViewsMap().put(video, 0);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                int numberOfVideo = i + 1;
                executorService.submit(() -> {
                    synchronized (videoManager) {
                        videoManager.addView("video " + numberOfVideo);
                        System.out.println("Просмотров на видео <video " + numberOfVideo + ">: " +
                                videoManager.getViewCount("video " + numberOfVideo));
                    }
                });
            }
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Error in awaitTermination block: " + e.getMessage(), e);
        }
    }
}
