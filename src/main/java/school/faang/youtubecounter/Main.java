package school.faang.youtubecounter;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 5;
    private static final int AWAIT_TERMINATION_TIMEOUT_MINUTES = 1;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager(new HashMap<>());
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "video %s".formatted(i);
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> {
                    manager.addView(videoId);
                    log.info(
                            "Добавлен просмотр для видео {}. Текущее количество: {}",
                            videoId,
                            manager.getViewCount(videoId));
                });
            }
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Не все потоки закрыты. Принудительное закрытие потоков.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Ожидание закрытия поток прервано.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Поток ожидания завершения выполнения был прерван.", e);
        }
    }
}