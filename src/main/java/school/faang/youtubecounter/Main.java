package school.faang.youtubecounter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "Видео №".concat(String.valueOf(i));
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> {
                    manager.addView(videoId);
                    log.info("{}, просмотров: {}", videoId, manager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.error("Задачи не завершились за 1 минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Главный поток был прерван во время ожидания, принудительно останавливаем пул.");
            executor.shutdownNow();
        }
    }
}