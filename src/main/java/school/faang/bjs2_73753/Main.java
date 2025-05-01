package school.faang.bjs2_73753;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREADS_COUNT = 2;
    private static final int PHOTOS_COUNT = 5;
    private static final int TERMINATION_TIMEOUT = 10;
    private static ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        executorService.execute(() -> {
            while (true) {
                uploader.startAutoUpload();
            }
        });
        executorService.execute(() -> {
            for (int i = 0; i < PHOTOS_COUNT; i++) {
                uploader.onNewPhotoAdded("photo%d.png".formatted(i + 1));
            }
        });
        dispose();
    }

    private static void dispose() {
        log.info("Start disposing executor service");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Not all tasks was stopped successfully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted exception with message {} was thrown", e.getMessage());
            executorService.shutdownNow();
        }
    }
}