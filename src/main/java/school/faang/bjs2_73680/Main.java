package school.faang.bjs2_73680;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final double MIN_VALUE = 3;
    private static final double MAX_VALUE = 6;
    private static final long MINUTES_TO_AWAIT = 1;
    private static final int LOADER_LOOP = 3;

    public static void main(String... args) throws InterruptedException {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(autoUploader::startAutoUpload);
        for (int i = 0; i < LOADER_LOOP; i++) {
            long batchSize = getRandomValue();
            for (int j = 0; j < batchSize; j++) {
                int finalI = i;
                int finalJ = j;
                executor.execute(() ->
                    autoUploader.onNewPhotoAdded("photo%s_%s.jpg".formatted(finalI, finalJ)));
            }
            Thread.sleep((getRandomValue() - 2) * 1000);
        }
        gracefullyShutdown(executor, autoUploader);
    }

    private static long getRandomValue() {
        double dbl = Math.random() / Math.nextDown(1.0);
        return Math.round(MIN_VALUE * (1.0 - dbl) + MAX_VALUE * dbl);
    }

    private static void gracefullyShutdown(ExecutorService executor, GooglePhotosAutoUploader autoUploader) {
        executor.shutdown();
        autoUploader.stop();
        try {
            if (executor.awaitTermination(MINUTES_TO_AWAIT, TimeUnit.MINUTES)) {
                log.info("All tasks are completed.");
            } else {
                List<Runnable> notExecuted = executor.shutdownNow();
                log.info("{} tasks failed to start.", notExecuted.size());
            }
        } catch (InterruptedException e) {
            log.error("error in gracefullyShutdown method: {}", e.getMessage(), e);
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
