package school.faang.sprint_3.task_48990;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock;
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        this.lock = new Object();
        photosToUpload = new CopyOnWriteArrayList<>();
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                log.info("Waiting for photos...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
            log.info("Photo auto-upload completed!");
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        if (photoPath.isEmpty()) {
            log.info("No new photos");
            return;
        }
        synchronized (lock) {
            if (!photosToUpload.contains(photoPath)) {
                photosToUpload.add(photoPath);
            }
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            log.info("Photo: {} added", photo);
        }
        photosToUpload.clear();
    }
}
