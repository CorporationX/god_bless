package school.faang.bjs48991;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
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
                log.error("Error  while autouploading {}", e.getMessage());
            }
        });

        try {
            if (!executorService.awaitTermination(15, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
