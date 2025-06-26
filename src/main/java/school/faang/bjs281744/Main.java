package school.faang.bjs281744;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final int NUM_THREADS = 10;
        final int NUM_VIDEOS = 5;

        VideoManager videoManager = new VideoManager();
        ExecutorService executore = Executors.newFixedThreadPool(NUM_THREADS);

        for (int videoIndex = 0; videoIndex < NUM_VIDEOS; videoIndex++) {
            final String videoId = "video_" + videoIndex;

            for (int threadIndex = 0; threadIndex < NUM_THREADS; threadIndex++) {
                executore.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.printf("Thread %s добавил просмотр для %s%n",
                            Thread.currentThread().getName(), videoId);
                });
            }
        }

        executore.shutdown();

        try {
            if (!executore.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Задачи не завершились за отведенное время");
                executore.shutdownNow();

                if (!executore.awaitTermination(5, TimeUnit.SECONDS)) {
                    System.out.println("Пул потоков не удалось корректно завершить");
                }
            }
        } catch (InterruptedException e) {
            executore.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("\n=== Результаты ===");
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video_" + i;
            int viewCount = videoManager.getViewCount(videoId);
            System.out.printf("%s: %s просмотров%n", videoId, viewCount);
        }

        System.out.printf("\nОжидаемое количество просмотров на видео: %s", NUM_THREADS);
    }
}
