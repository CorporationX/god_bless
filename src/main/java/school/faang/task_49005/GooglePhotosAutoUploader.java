package school.faang.task_49005;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final Logger log = LoggerFactory.getLogger(GooglePhotosAutoUploader.class);
    private final List<String> photosToUpload = new ArrayList<>();
    private boolean running = true;

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            while (running) {
                if (photosToUpload.isEmpty()) {
                    try {
                        photosToUpload.wait();
                        log.info("Waiting for photos to upload");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
            log.info("Added photo: {}", photoPath);
        }
    }

    public void uploadPhotos() {
        log.info("Uploading photos...");
        photosToUpload.clear();
    }

    public void stopUploader() {
        synchronized (photosToUpload) {
            running = false;
            photosToUpload.notify();
        }
    }

}
