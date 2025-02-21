package school.faang.viewcounter;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 10;
    private static final int AWAIT_TERMINATION = 5;

    public static void main(String[] args) {

        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        Random random = new Random();
        String[] videoIds = {"Thread", "Cats", "Election"};

        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> videoManager.addView(videoIds[random.nextInt(0, 3)]));
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION, TimeUnit.SECONDS)) {
                log.warn("Потоки не завешились за {} секунд. Завершаю принудительно...", AWAIT_TERMINATION);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток прерван во время завершения работы ", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        Arrays.stream(videoIds)
                .forEach(videoId ->
                        log.info("Видео {} набрало {} просмотров", videoId, videoManager.getViewCount(videoId)));
    }
}
