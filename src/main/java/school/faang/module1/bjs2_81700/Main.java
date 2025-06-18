package school.faang.module1.bjs2_81700;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 10;
    private static final int TIMEOUT = 10;
    private static final String VIDEO_PREFIX = "Video-%s";

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = String.format(VIDEO_PREFIX, i);
            for (int j = 0; j < NUM_THREADS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    log.info("{} просмотров: {}", videoId, videoManager.getViewCount(videoId));
                });
            }
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Некоторые задачи не завершились вовремя. Принудительное завершение");
                executorService.shutdownNow();
            } else {
                log.info("Все задачи успешно завершены");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Главный поток был прерван во время ожидания. Завершаем принудительно", e);
            executorService.shutdownNow();
        }
    }
}