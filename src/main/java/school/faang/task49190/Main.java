package school.faang.task49190;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager manager = new VideoManager();

        IntStream.range(0, NUM_VIDEOS).forEach(i -> IntStream.range(0, NUM_THREADS / NUM_VIDEOS)
                .forEach(j -> executorService.execute(() -> {
                    manager.addView(String.valueOf(i));
                    manager.getViewCount(String.valueOf(i));
                })));

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS)) {
                log.info("Задача выполнена");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
    }
}
