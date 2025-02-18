package school.faang.googlephotosync;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Getter
public class GooglePhotosAutoUploader {
    private static final Logger LOGGER = Logger.getLogger(GooglePhotosAutoUploader.class.getName());
    private final Object lock = new Object();
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() {
        synchronized (lock) {

            try {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                uploadPhotos();

            } catch (InterruptedException e) {
                LOGGER.info(e.getMessage());
            }
        }
    }

    public void onNewPhotoAdded(@NonNull String photoPath) {
        synchronized (lock) {
            LOGGER.info("New photo added: " + photoPath);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        LOGGER.info("Search " + photosToUpload.size() + " photos\nDeleting " + photosToUpload.get(0) + " photo");
        photosToUpload.remove(0);
    }
}
