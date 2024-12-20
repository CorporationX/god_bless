package school.faang.google_foto;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    log.info("Waiting for new images");
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("Thread error {}", e.getMessage());
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> log.info("Image {} successfully uploaded to server", photo));
        photosToUpload.clear();
        log.info("All images uploaded");
    }
}
