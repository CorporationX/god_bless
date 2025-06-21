package school.faang.bjs2_81685;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_THREADS; j++) {
                String videoId = "video" + i;
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    log.info("Video {} просмотров: {}", videoId, videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("Задачи не завершились за 1 минуту, принудительно останавливаем…");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ошибка при ожидании завершения задач.", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
