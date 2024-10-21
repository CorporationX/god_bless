package mod1sp3.youtubeViewCounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video " + (i + 1);
            videoManager.getViewsMap().put(videoId, 0);

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.execute(() -> {
                    synchronized (videoManager) {
                        videoManager.addView(videoId);
                        System.out.println("Просмотров на видео <"+ videoId + ">: " + videoManager.getViewCount(videoId));
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
