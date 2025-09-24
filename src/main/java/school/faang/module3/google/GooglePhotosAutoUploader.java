package school.faang.module3.google;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (this) {
            try {
                if (photosToUpload.isEmpty()) {
                    log.info("List of photo paths is empty, wait new photos...");
                    this.wait();
                    uploadPhotos();
                } else {
                    uploadPhotos();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (this) {
            log.info("added new photo by path: {}", photoPath);
            photosToUpload.add(photoPath);
            this.notify();
        }
    }

    private void uploadPhotos() throws InterruptedException {
        log.info("Starting uploading photos...");
        Thread.sleep(5000);
        photosToUpload.forEach(p -> log.info("Photo was uploaded by path: {}", p));
        photosToUpload.clear();
        log.info("All photos were uploaded, list is empty");
    }
}
