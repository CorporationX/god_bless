package school.faang.sprint3.bjs_48843;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload;
    private final Object lock = new Object();
    private boolean readyToUpload = true;

    public GooglePhotosAutoUploader() {
        photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (readyToUpload) {
                if (photosToUpload.isEmpty()) {
                    try {
                        log.info("waiting for photos...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        readyToUpload = false;
                        log.error("No photos to upload");
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(log::info);
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
