package school.faang.task_61845;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 5;
    private static final int TIMEOUT_SECONDS = 60;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int videoId = 1; videoId <= NUM_VIDEOS; videoId++) {
            final String videoIdStr = "video" + videoId;

            for (int i = 0; i < NUM_THREADS; i++) {
                executorService.submit(() -> {
                    videoManager.addView(videoIdStr);
                    System.out.println(Thread.currentThread().getName() + " посмотрел " + videoIdStr);
                });
            }
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                System.out.println("Задачи не завершены в течение времени ожидания, принудительное завершение.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Задачи были прерваны.");
            executorService.shutdownNow();
        }

        for (int videoId = 1; videoId <= NUM_VIDEOS; videoId++) {
            System.out.println("Итоговое количество просмотров для видео " + "video" + videoId + ": "
                    + videoManager.getViewCount("video" + videoId));
        }
    }
}
