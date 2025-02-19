package school.faang.google_photo_sync.BJS2_61771;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final Logger LOGGER = LoggerFactory.getLogger(GooglePhotosAutoUploader.class);

    private final Object lock = new Object();

    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                LOGGER.info("В ожидании");
                lock.wait();
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            LOGGER.info("Принёс фотки");
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for (Iterator<String> iterator = photosToUpload.iterator(); iterator.hasNext(); ) {
            String photo = iterator.next();
            LOGGER.info("Uploading photo: {}", photo);
            iterator.remove();
        }
    }
}
