package school.faang.bjs2_81921_google_photos_upload;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class GooglePhotosAutoUploader {
    private static final int MAX_UPLOAD_DELAY_MS = 1000;

    private final Object lock = new Object();
    private final List<String> photosToUpload;
    private boolean isShutdownRequested;

    public GooglePhotosAutoUploader(@NonNull List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
    }

    public void startAutoUpload() throws InterruptedException {
        while (true) {
            Queue<String> toUploadNow;

            synchronized (lock) {
                if (isShutdownRequested && photosToUpload.isEmpty()) {
                    log.info("Shutdown requested and no photos in the queue, Auto-upload shutting down.");
                    break;
                }

                while (photosToUpload.isEmpty() && !isShutdownRequested) {
                    try {
                        log.info("No photos in the queue, waiting...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.warn("Upload thread interrupted, shutting down...");
                        return;
                    }
                }

                toUploadNow = new LinkedList<>(photosToUpload);
                photosToUpload.clear();
            }

            uploadPhotos(toUploadNow);
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

    private void uploadPhotos(Queue<String> photos) {
        while (!photos.isEmpty()) {
            String photo = photos.poll();
            log.info("Starting upload of photo {}", photo);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1, MAX_UPLOAD_DELAY_MS));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            log.info("Completed upload of photo {}", photo);
        }
    }
}
