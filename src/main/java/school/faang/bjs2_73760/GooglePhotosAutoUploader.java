package school.faang.bjs2_73760;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosPathToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                while (photosPathToUpload.isEmpty()) {
                    log.info("Attempt to send a photo");
                    try {
                        log.info("No new photos, waiting");
                        lock.wait();
                    } catch (InterruptedException ex) {
                        log.error("Thread stoppage error");
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosPathToUpload.add(photoPath);
            log.info("Added new photo with path {}", photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        photosPathToUpload.forEach(photoPath -> log.info("Photo with path {} sent", photoPath));
        photosPathToUpload.clear();
    }
}
