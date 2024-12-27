package school.faang.task_49101;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    private void uploadPhotos() {
        synchronized (lock) {
            log.info("Begin upload photos...");
            for (String photo : photosToUpload) {
                log.info("Upload: {}", photo);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Uploading is interrupted");
                    return;
                }
            }
            photosToUpload.clear();
            log.info("All photos are uploaded successfully.");
        }
    }

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        log.info("There are no photos for upload. Waiting....");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("Thread was interrupted");
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
            log.info("Added a new photo: {}", photoPath);
            lock.notify();
        }
    }
}
