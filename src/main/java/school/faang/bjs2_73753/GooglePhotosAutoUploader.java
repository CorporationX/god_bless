package school.faang.bjs2_73753;

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
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                uploadPhotos();
            } catch (InterruptedException e) {
                log.error("Interrupted exception with message {} was thrown", e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> log.info("Uploading new photo: {}", photo));
        photosToUpload.clear();
    }
}