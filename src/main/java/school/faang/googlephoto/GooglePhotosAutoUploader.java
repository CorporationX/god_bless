package school.faang.googlephoto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private static final Logger LOGGER = LoggerFactory.getLogger(GooglePhotosAutoUploader.class);
    private final Object lock = new Object();

    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        LOGGER.error("Поток был прерван во время ожидания с ошибкой: {}", e.getMessage());
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notifyAll();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> LOGGER.info("Фото {} загружено!", photo));
        photosToUpload.clear();
    }
}
