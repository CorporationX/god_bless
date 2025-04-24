package school.faang.googlephotosync;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor
public class GooglePhotoAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            List<String> batch;
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        log.info("Waiting for photos to upload...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("Thread was interrupted during waiting.", e);
                    }
                }
                batch = new ArrayList<>(photosToUpload);
                photosToUpload.clear();
            }
            uploadBatch(batch);
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        if (photoPath == null || photoPath.isEmpty()) {
            throw new IllegalArgumentException("Photo path must not be empty!");
        }
        synchronized (lock) {
            log.info("New photo {} was added.", photoPath);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        for (String path : photosToUpload) {
            log.info("Uploading photo {}...", path);
            photosToUpload.remove(path);
        }
        if (photosToUpload.isEmpty()) {
            log.info("All photos uploaded.");
        } else {
            log.error("Something went wrong.");
        }
    }

    private void uploadBatch(List<String> batch) {
        synchronized (lock) {
            for (String path : batch) {
                log.info("Uploading photo {}...", path);
                photosToUpload.remove(path);
            }
        }
        if (photosToUpload.isEmpty()) {
            log.info("All photos uploaded.");
        } else {
            log.error("Something went wrong.");
        }
    }
}
