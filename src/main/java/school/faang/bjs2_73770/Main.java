package school.faang.bjs2_73770;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int THREADS_COUNT = 2;
    public static final int AWAIT_TIMEOUT_MINUTES = 1;

    public static void main(String[] args) {
        GooglePhotosAutoUploader photosAutoUploader = new GooglePhotosAutoUploader();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        executorService.execute(photosAutoUploader::startAutoUpload);
        executorService.execute(() -> {
            photosAutoUploader.onNewPhotoAdded("pict1");
            photosAutoUploader.onNewPhotoAdded("pict2");
        });
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                log.warn("Timeout: photos auto uploading were not completed within the allotted time");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("The thread was interrupted while waiting for completion auto uploading " +
                    "pictures", e);
        }
    }
}
