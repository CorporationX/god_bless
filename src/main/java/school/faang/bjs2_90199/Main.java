package school.faang.bjs2_90199;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 3;
    private static final int NUM_VIDEOS = 5;
    private static final int AWAIT_MINUTES = 1;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService execute = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                execute.submit(() -> {
                    synchronized (videoId) {
                        videoManager.addView(videoId);
                        int count = videoManager.getViewCount(videoId);
                        log.info("Ваше видео {}, набрало {} просмотров", videoId, count);
                    }
                });
            }
        }
        execute.shutdown();
        try {
            if (!execute.awaitTermination(AWAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Потоки не закончили свою работу за {}. Останавливаем потоки", AWAIT_MINUTES);
                execute.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка при ожидании завершения потоков");
            execute.shutdownNow();
        }
    }
}
