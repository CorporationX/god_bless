package school.faang;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_49258.VideoManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int j = 0; j < NUM_VIDEOS; j++) {
            String videoId = "Video" + j;

            for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
                executor.submit(() -> {
                    manager.addView(videoId);
                    log.info("Количество просмотров видео {} составляет {}", videoId, manager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("Все видео обработаны, общее количество видео = {}, общее количество просмотров = {}",
                        manager.getAllVideoCount(), manager.getAllViewCount());
            } else {
                log.info("Видео не успели обработаться за указанное время");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Возникла ошибка при выполнении метода awaitTermination()", e);
        }
    }
}
