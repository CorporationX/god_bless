package school.faang.bjs249110;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotoAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        log.info("No photos to upload. Waiting for new photos...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        log.error("Auto-upload thread interrupted.", e);
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        log.info("Starting upload of {} photos.", photosToUpload.size());
        for (String photo : photosToUpload) {
            log.info("Uploading photo: {}", photo);
            try {
                Thread.sleep(1000); // Simulate upload time
            } catch (InterruptedException e) {
                log.error("Upload interrupted.", e);
                Thread.currentThread().interrupt();
                return;
            }
        }
        photosToUpload.clear();
        log.info("Finished uploading photos.");
    }

    public void onNewPhotoAdded(String photoPath) {
        if (photoPath == null || photoPath.trim().isEmpty()) {
            log.warn("Invalid photo path provided.");
            throw new IllegalArgumentException("Invalid photo path provided.");
        }
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("New photo added: {}. Notifying upload thread...", photoPath);
            lock.notify();
        }
    }
}
