package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final Logger logger = LoggerFactory.getLogger(GooglePhotosAutoUploader.class);
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    logger.error("Wait was interrupted.");
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            updatePhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            logger.info("{} has been uploaded to photos", photoPath);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void updatePhotos() {
        logger.info("The photos have been uploaded.");
        photosToUpload.clear();
    }
}
