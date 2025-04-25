package school.faang.google_photo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREADS_COUNT = 2;
    private static final int MAX_WAIT_MINUTES = 1;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        executor.execute(new Thread(() -> {
            uploader.onNewPhotoAdded("Path1");
            uploader.onNewPhotoAdded("Path2");
            uploader.onNewPhotoAdded("Path3");
            uploader.onNewPhotoAdded("Path4");

        }));

        executor.execute(new Thread(uploader::startAutoUpload));
        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Not all tasks are completed in {} minutes. Attempting to force stop", MAX_WAIT_MINUTES);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Waiting for threads to finish is interrupted.");
            executor.shutdownNow();
        }
        log.info("All tasks are completed!");
    }
}
