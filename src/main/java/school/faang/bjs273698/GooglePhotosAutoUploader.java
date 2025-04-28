package school.faang.bjs273698;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            try {
                while (true) {
                    if (photosToUpload.isEmpty()) {
                        log.info("No one photo to upload. Waiting...");
                        lock.wait();
                    }
                    uploadPhotos();
                }
            } catch (InterruptedException e) {
                log.error("Thread interrupted: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach((path) -> log.info("Photo uploaded: {}", path));
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Photo added \"{}\". Notifying.", photoPath);
            lock.notify();
        }
    }
}
