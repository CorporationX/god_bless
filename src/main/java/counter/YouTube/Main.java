package counter.YouTube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int NUM_THREADS = 100;
    private final static int NUM_VIDEOS = 5;
    private final static int SECONDS_AWAIT = 30;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video_" + i;

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    int viewCount = videoManager.getViewCount(videoId);
                    System.out.printf("У видео: %s %d просмотров\n", videoId, viewCount);
                });
            }
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(SECONDS_AWAIT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
