package bjs2_73714;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<String>();

    public void startAutoUploader() {
        synchronized (lock) {
            try {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                uploadPhoto();
            } catch (InterruptedException e) {
                log.error("automatic download aborted");
                throw new IllegalStateException("the current thread is interrupted");
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhoto() {
        log.info("Uploading photo...");
        for (String photoPath : photosToUpload) {
            log.info("Uploading photo: " + photoPath);
        }
        log.info("Upload complete");
        photosToUpload.clear();
    }
}
