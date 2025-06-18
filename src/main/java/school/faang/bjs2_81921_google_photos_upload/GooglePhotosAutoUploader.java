package school.faang.bjs2_81921_google_photos_upload;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload;
    private boolean isShutdownRequested;

    public GooglePhotosAutoUploader(@NonNull List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
    }

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (isShutdownRequested && photosToUpload.isEmpty()) {
                    log.info("Shutdown requested and no photos in the queue, Auto-upload shutting down.");
                    break;
                } else if (photosToUpload.isEmpty()) {
                    log.info("No photos in the queue, waiting...");
                    lock.wait();
                } else {
                    uploadPhotos();
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void gracefulShutdown() {
        synchronized (lock) {
            isShutdownRequested = true;
            lock.notify();
        }
    }

    private void uploadPhotos() {
        while (!photosToUpload.isEmpty()) {
            String photo = photosToUpload.get(0);
            log.info("Uploading photo {}", photo);
            photosToUpload.remove(0);
        }
    }
}
