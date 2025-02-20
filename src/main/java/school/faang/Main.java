package school.faang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS_COUNT = 3;
    private static final int VIDEOS_COUNT = 3;
    private static final int TIMEOUT_SECONDS = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        VideoManager videoManager = new VideoManager();

        for (int i = 0; i < VIDEOS_COUNT; ++i) {
            String videoId = String.format("video %d", i);
            for (int j = 0; j < THREADS_COUNT; ++j) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println(String.format("Video %s has %d views.",
                            videoId, videoManager.getViewCount(videoId)));
                });
            }
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                System.out.println("Not all tasks have been completed on time.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("awaitTermination was interrupted");
            throw new RuntimeException(e);
        }
    }
}
