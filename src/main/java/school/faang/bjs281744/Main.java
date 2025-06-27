package school.faang.bjs281744;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int numThreads = 10;
    private static final int numVideos = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int videoIndex = 0; videoIndex < numVideos; videoIndex++) {
            final String videoId = "video_" + videoIndex;

            for (int threadIndex = 0; threadIndex < numThreads; threadIndex++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    log.info("Thread {} добавил просмотр для {}",
                            Thread.currentThread().getName(), videoId);
                });
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                log.info("Задачи не завершились за отведенное время");
                executor.shutdownNow();

                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    log.info("Пул потоков не удалось корректно завершить");
                }
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        log.info("\n=== Результаты ===");
        
        for (int i = 0; i < numVideos; i++) {
            String videoId = "video_" + i;
            int viewCount = videoManager.getViewCount(videoId);
            log.info("{}: {} просмотров", videoId, viewCount);
        }

        log.info("\nОжидаемое количество просмотров на видео: {}", numThreads);
    }
}