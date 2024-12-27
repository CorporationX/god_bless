package school.faang.googlephotosyncbjs49037;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final Logger logger =
            LoggerFactory.getLogger(GooglePhotosAutoUploader.class);
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private static final int UPLOAD_DELAY_MS = 1000;

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    logger.info("There are no new photos. Expectation...");
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.error("Upload interrupted", e);
                    return;
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            logger.info("Added a new photo: " + photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            List<String> photosToUploadCopy = new ArrayList<>(photosToUpload);
            photosToUploadCopy.forEach(photoPath -> {
                logger.info("Upload photo: " + photoPath);
                try {
                    Thread.sleep(UPLOAD_DELAY_MS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.error("Upload interrupted", e);
                    return;
                }
                photosToUpload.remove(photoPath);
            });
            logger.info("All photo upload");
        }
    }
}
