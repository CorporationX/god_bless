package faang.school.godbless.BJS2_24443;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 20;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        Random random = new Random();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "Видео " + i;
            int numViews = random.nextInt(NUM_THREADS / 2) + 1;
            for (int j = 0; j < numViews; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    System.out.println("ID: " + videoId + " - Общее количество просмотров после добавления: " + videoManager.getViewCount(videoId));
                });
            }
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
            videoManager.printViewsMap();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}