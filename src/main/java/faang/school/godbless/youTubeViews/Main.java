package faang.school.godbless.youTubeViews;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 20;

    public static void main(String[] args) {

        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId =  Integer.toString(i+1);

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    videoManager.getViewCount(videoId).ifPresentOrElse(
                            (viewCount) -> System.out.println("Video id: " + videoId + ", Views: " + viewCount),
                            () -> System.out.println("Video with id: " + videoId + " not found"));
                });
            }
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
