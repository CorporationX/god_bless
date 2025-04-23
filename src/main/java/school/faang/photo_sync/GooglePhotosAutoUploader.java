package school.faang.photo_sync;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
@AllArgsConstructor
public class GooglePhotosAutoUploader {
    private final Queue<String> photosToUpload = new LinkedList<>();

    public void onNewPhotoAdded(String photoPath) {
        log.debug("executing onNewPhotoAdded() by Thread {}", Thread.currentThread().getName());
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            log.info("New photo added: " + photoPath);
            photosToUpload.notify();
            log.info("Notified the other Thread to try to upload");
        }
    }

    public void startAutoUpload() {
        log.debug("executing startAutoUpload() by Thread {}", Thread.currentThread().getName());
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                log.info("No photos to upload, calling wait()");
                try {
                    photosToUpload.wait();
                } catch (InterruptedException e) {
                    log.info("Interrupted while waiting for no photos to upload", e);
                    Thread.currentThread().interrupt();
                }
            } else {
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        log.debug("executing uploadPhotos() by Thread {}", Thread.currentThread().getName());
        log.info("Uploading photos ...");
        String pathOfRemovedPhoto = photosToUpload.poll();
        log.info("Uploaded photo by path {}", pathOfRemovedPhoto);
        log.info("Current number of photos to be uploaded: {}", photosToUpload.size());
    }
}
