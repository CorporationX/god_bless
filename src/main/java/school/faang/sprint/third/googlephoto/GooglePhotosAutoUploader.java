package school.faang.sprint.third.googlephoto;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (photosToUpload) {
                log.info("Starting auto upload...");
                if (photosToUpload.isEmpty()) {
                    log.info("No photos to upload");
                    try {
                        photosToUpload.wait();
                    } catch (InterruptedException e) {
                        log.error("Interrupted while waiting for photos to upload");
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
                uploadPhotos();
                log.info("Auto upload complete.");
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            validatePhotoPath(photoPath);
            log.info("New photo added: {}", photoPath);
            photosToUpload.add(photoPath);
            photosToUpload.notifyAll();
        }
    }

    private void uploadPhotos() {
        log.info("Uploading photos...");
        photosToUpload.forEach(googlePhotoUrl -> log.info("{} photos uploaded", googlePhotoUrl));
        photosToUpload.clear();
        photosToUpload.notifyAll();
    }

    private void validatePhotoPath(String photoPath) {
        if (photoPath == null || photoPath.isEmpty()) {
            throw new IllegalArgumentException("Invalid photoPath");
        }
    }
}
