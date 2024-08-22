package faang.school.godbless.BJS2_24330;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 10000;
    private static final int NUM_VIDEOS = 100;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        Random rand = new Random();

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            videoManager.addVideo(i);
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            executor.execute(() -> {
                int videoId = rand.nextInt(1, NUM_VIDEOS);
                videoManager.addView(videoId);
                System.out.printf("У видео %d просмотров: %d%n", videoId, videoManager.getViewCount(videoId));
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println(videoManager.getViewsMap());
    }
}
