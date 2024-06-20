package faang.school.godbless.synchronization.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 1000;
    private static final int NUM_VIDEOS = 10;
    private static final int TIMEOUT = 1;

    public static void main(String[] args) {

        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            Video video = new Video("video - " + i);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(video.getVideoId());
                    videoManager.getViewCount(video.getVideoId());
                });
            }

        }
        executorService.shutdown();

        try {
            boolean awaitTermination = executorService.awaitTermination(TIMEOUT, TimeUnit.MINUTES);
            if (awaitTermination) {
                System.out.println("All thread completed");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
