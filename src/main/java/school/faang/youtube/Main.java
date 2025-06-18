package school.faang.youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Danil Pudovkin
 * @since 18.06.2025
 */
@Slf4j
public class Main {

    private static final int NUM_THREADS = 4;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        var videoManager = new VideoManager();
        var executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int videoId = 0; videoId < NUM_VIDEOS; videoId++) {
            for (int threadId = 0; threadId < NUM_THREADS; threadId++) {
                var finalVideoId = "Video%d".formatted(videoId);
                executor.execute(() -> videoManager.addView(finalVideoId));
                var future = executor.submit(() -> videoManager.getViewCount(finalVideoId));
                try {
                    log.info("Новые просмотры для видео {}: {}", finalVideoId, future.get());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток {} прерван", Thread.currentThread().getName(), e.getCause());
                } catch (ExecutionException e) {
                    log.error("Ошибка добавления просмотра для видео {}", finalVideoId, e.getCause());
                }
            }
        }
        executor.shutdown();
        var executorName = executor.getClass().getSimpleName();
        log.info("{} | Запрос на завершение работы", executorName);
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.info("{} | Принудительное завершение работы", executorName);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            log.info("Поток {} прерван; {} | Принудительное завершение работы",
                    Thread.currentThread().getName(), executorName, e.getCause());
        }
        log.info("{} | Завершение работы", executorName);
        for (int videoId = 0; videoId < NUM_VIDEOS; videoId++) {
            var finalVideoId = "Video%d".formatted(videoId);
            log.info("Количество просмотров для видео {}: {}", finalVideoId, videoManager.getViewCount(finalVideoId));
        }
    }
}
