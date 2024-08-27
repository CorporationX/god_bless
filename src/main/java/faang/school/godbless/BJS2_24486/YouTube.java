package faang.school.godbless.BJS2_24486;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class YouTube {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 20;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
            String videoId = Integer.toString(i + 1);
            executorService.execute(() -> {
                videoManager.addView(videoId);

                videoManager.getViewCount(videoId).ifPresentOrElse(viewCount ->
                        System.out.printf("Video ID: %s, Views: %d%n", videoId, viewCount),
                        () -> System.out.println("Video with id: " + videoId + " not found")
                );
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(NUM_VIDEOS * 2, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
