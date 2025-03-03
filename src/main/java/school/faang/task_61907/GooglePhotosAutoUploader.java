package school.faang.task_61907;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                while (photosToUpload.isEmpty()) {
                    try {
                        log.info("Waiting for photos...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        log.error("Interrupted while waiting for photos to upload", e);
                        Thread.currentThread().interrupt();
                        return; // Прерываем цикл в случае восстановления прерванного потока.
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Photo added: {}", photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                log.info("No photos to upload");
                return;
            }

            photosToUpload.forEach((photoPath) -> log.info("Uploading photo: {}", photoPath));

            log.info("Photos uploaded successfully");
            photosToUpload.clear();
            log.info("Photo library cleaned!");
        }
    }
}
