package school.faang.task_61704;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(GooglePhotosAutoUploader.class);
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    @Override
    public void run() {

    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    LOG.info("List is empty. Waiting...");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    LOG.error("Thread was interrupted while waiting for photos to upload: ", e);
                }
            }
            LOG.info("{} new photos has been added to the list. Starting upload photos.", photosToUpload.size());
            uploadPhotos();
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

    public void uploadPhotos() {
        photosToUpload.forEach(photo -> LOG.info("Uploading photo {} to the server.", photo));
        LOG.info("{} photos has been successfully added to the server.", photosToUpload.size());
        photosToUpload.clear();
        LOG.info("The list has benn cleared.");

    }
}
