package school.faang.viewcounter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 10;
    private static final int AWAIT_TERMINATION = 5;
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

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
                LOGGER.warn("Потоки не завешились за {} секунд. Завершаю принудительно...", AWAIT_TERMINATION);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            LOGGER.error("Поток прерван во время завершения работы ", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        Arrays.stream(videoIds)
                .forEach(videoId ->
                        LOGGER.info("Видео {} набрало {} просмотров", videoId, videoManager.getViewCount(videoId)));
    }
}
