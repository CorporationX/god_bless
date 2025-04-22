package school.faang.sync.google_photos;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (photosToUpload) {
            try {
                while (true) {
                    if (photosToUpload.isEmpty()) {
                        log.info("Waiting for photos");
                        photosToUpload.wait();
                    } else {
                        uploadPhotos();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Upload thread was interrupted");
            }

        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            log.info("Photo {} was added", photoPath);
            photosToUpload.notify();
        }
    }

    private void uploadPhotos() {
        log.info("Photos {} were uploaded", photosToUpload);
        photosToUpload.clear();
    }
}
