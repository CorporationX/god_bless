package school.faang.sprint3.task_49223;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;

        VideoManager manager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        // Добавляем задачи в ExecutorService
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    manager.addView(videoId); // Добавляем просмотр
                    System.out.println("Video " + videoId + " просмотров: " + manager.getViewCount(videoId));
                });
            }
        }

        executor.awaitTermination(3, TimeUnit.SECONDS);
        executor.shutdown();

        manager.getAllVideo();
    }
}

