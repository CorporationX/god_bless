package faang.school.godbless.youtubeviewcounter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 100;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        Random random = new Random();
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            videoManager.addVideo("Video " + i);
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            executorService.execute(() -> {
                String videoId = "Video " + (random.nextInt(NUM_VIDEOS) + 1);
                videoManager.addView(videoId);
                int viewCount = videoManager.getViewCount(videoId);
                System.out.printf("%s has %d views%n", videoId, viewCount);
            });
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}