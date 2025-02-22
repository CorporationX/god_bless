package school.faang.googlephotosync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(GooglePhotosAutoUploader.class);

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    logger.info("Waiting for new photos...");
                    lock.wait();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            logger.info("Uploading photos!");
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.clear();
            logger.info("All photos uploaded");
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
            logger.info("New photos added to list");
        }
    }
}
