package school.faang.bjs48991;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final long TEST_TIME = 10_000;
    public static void main(String[] args) {
        Random random = new Random();
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        var executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(() -> uploader.onNewPhotoAdded(String.valueOf(random.nextInt(1000, 9999))),
                0, 2000, TimeUnit.MILLISECONDS);
        executorService.submit(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                log.info("Was interrupted while autouploading {}", e.getMessage());
            }
        });

        try {
            Thread.sleep(TEST_TIME);
        } catch (InterruptedException e) {
            log.error("Error while testing within test time");
        }
        log.info("Test time expired, shutting down");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TEST_TIME, TimeUnit.MILLISECONDS)) {
                log.info("Shutting now");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
