package school.faang.bjs2_90468;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();


    public void startAutoUpload() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    log.warn("No photos to upload. Waiting for new photos...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        log.error("UploaderThread is interrupted while waiting");
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
                uploadPhotos();
            }
        }
    }


    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("New photo added: " + photoPath);
            lock.notifyAll();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            log.info("New photos uploaded");
            photosToUpload.clear();
        }
    }

}

