package school.faang.bjs2_73770;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    log.info("There are no photos for auto uploading");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new IllegalStateException("Waiting for new photos to load was interrupted", e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> log.info("Photo with path: {} was uploaded to Google Photos", photo));
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            log.info("New photo '{}' was added to upload", photoPath);
            photosToUpload.add(photoPath);
            lock.notifyAll();
        }
    }
}
