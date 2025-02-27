package school.faang.sprint3.task_61704;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final Logger LOG = LoggerFactory.getLogger(GooglePhotosAutoUploader.class);
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        LOG.info("List is empty. Waiting...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        LOG.error("Thread was interrupted while waiting for photos to upload: ", e);
                        return;
                    }
                }

                LOG.info("{} new photos have been added to the list. Starting upload photos.", photosToUpload.size());
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            LOG.info("Adding a new photo {}", photoPath);
            photosToUpload.add(photoPath);
            LOG.info("{} has been added", photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        while (!photosToUpload.isEmpty()) {
            String photo = photosToUpload.remove(0);
            LOG.info("Uploading photo: {}", photo);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOG.error("Upload interrupted: ", e);
                return;
            }
        }
    }
}
