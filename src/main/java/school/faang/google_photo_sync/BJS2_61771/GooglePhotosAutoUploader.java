package school.faang.google_photo_sync.BJS2_61771;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final Logger LOGGER = LoggerFactory.getLogger(GooglePhotosAutoUploader.class);

    private final Object lock = new Object();

    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        while (true) {
            synchronized (photosToUpload) {
                while (photosToUpload.isEmpty()) {
                    LOGGER.info("В ожидании новых фотографий...");
                    photosToUpload.wait(); // Поток засыпает, пока нет фотографий
                }
                uploadPhotos();
            }
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
        for (String photo : photosToUpload) {
            LOGGER.info("Uploading photo: {}", photo);
        }
        photosToUpload.clear();
    }
}
