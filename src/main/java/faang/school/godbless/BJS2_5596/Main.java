package faang.school.godbless.BJS2_5596;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 100;
        final Random NUM_VIEWS = new Random();
        final int MAX_NUM_VIEWS_ON_VIDEO = 100;

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++){
            String videoId = "Видео: " + i;
            for (int j = 0; j < NUM_VIEWS.nextInt(MAX_NUM_VIEWS_ON_VIDEO); j++){
                executor.submit(() -> {
                   videoManager.addView(videoId);
                    System.out.println("Количество просмотров " + videoId + ": " + videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
