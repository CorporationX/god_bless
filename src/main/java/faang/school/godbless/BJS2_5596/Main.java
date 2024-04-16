package faang.school.godbless.BJS2_5596;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 1;

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= 100; i++){
            String videoId = "Видео: " + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++){
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
