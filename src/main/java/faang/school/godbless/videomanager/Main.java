package faang.school.godbless.videomanager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;

        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    int viewCount = videoManager.getViewCount(videoId);
                    System.out.println(Thread.currentThread().getName() + ": " + videoId + " просмотры: " + viewCount);
                });
            }
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Все задачи завершены.");
            } else {
                System.err.println("Не удалось завершить все задачи в отведенное время.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Ожидание завершения задач было прервано.");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
