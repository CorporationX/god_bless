package school.faang.sprint3.bjs2_61595;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_OF_THREADS = 5;
    private static final int NUM_VIDEOS = 50;
    private static final int AWAIT_TERMINATION = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_OF_THREADS);
        Random random = new Random();

        String[] videoIds = {"Spring", "Cars", "Wild"};

        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_OF_THREADS; j++) {
                executorService.submit(() -> videoManager.addView(videoIds[random.nextInt(0, 3)]));
            }
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION, TimeUnit.SECONDS)) {
                log.debug("Потоки не завешились за {} секунд. Завершаю принудительно...", AWAIT_TERMINATION);
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток прерван во время завершения работы ", e);
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        Arrays.stream(videoIds)
                .forEach(videoId ->
                        log.info("Видео {} набрало {} просмотров", videoId, videoManager.getViewCount(videoId)));
    }
}

