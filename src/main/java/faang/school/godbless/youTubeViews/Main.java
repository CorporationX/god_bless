package faang.school.godbless.youTubeViews;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 50;

    public static void main(String[] args) {

        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            videoManager.addVideo(Integer.toString(i));
        }

        for (Map.Entry<String, Integer> entry : videoManager.getViewsMap().entrySet()) {
            executorService.submit(() -> {
                videoManager.addView(entry.getKey());
                videoManager.getViewCount(entry.getKey()).ifPresentOrElse(
                        (viewCount) -> System.out.println("Video with id: " + entry.getKey() + " has " + viewCount + " views"),
                        () -> System.out.println("Video with id: " + entry.getKey() + "not found"));
            });
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
