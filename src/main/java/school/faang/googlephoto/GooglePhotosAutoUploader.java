package school.faang.googlephoto;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        log.info("No new photos available");
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Thread interrupted while waiting for new photos", e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            if (photoPath != null && !photoPath.isBlank()) {
                photosToUpload.add(photoPath);
                lock.notifyAll();
            }
        }
    }

    private void uploadPhotos() {
        log.info("New photos have been uploaded");
        photosToUpload.clear();
    }
}