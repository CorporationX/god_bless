package faang.school.godbless.googlephotosync;

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
                try {
                    while (photosToUpload.isEmpty()) {
                        log.info("No new photos. Waiting for new photos...");
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                    return;
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("New photo added: {}", photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photoPath -> log.info("Photo has been uploaded: {}", photoPath));
        photosToUpload.clear();
        log.info("All photos uploaded");
    }
}