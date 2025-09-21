package school.faang.bjs2_90099;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int NUM_THREADS = 5;
    public static final int NUM_VIDEOS = 1000000;
    public static final int TIMEOUT = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        log.info("Программа запущена");
        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_THREADS; j++) {
                int finalI = i + 1;
                executorService.submit(() -> videoManager.addView(String.format("Video#%d", finalI)));
            }
        }
        executorService.shutdown();
        try {
            log.info("Программа ожидает завершения всех задач ...");
            if (executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Все задачи завершены");
            } else {
                log.info("Задачи не успели успешно завершиться");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            executorService.shutdownNow();
        }
    }
}
