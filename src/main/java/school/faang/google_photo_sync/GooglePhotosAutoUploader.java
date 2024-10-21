package school.faang.google_photo_sync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    public void startAutoLoad() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        log.error("Thread interrupted while waiting", e);
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
            photosToUpload.add(photoPath);
            log.info("New photo added: " + photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        for (String photo : photosToUpload) {
            log.info("Uploading photo to server: " + photo);
        }
        photosToUpload.clear();
    }
}