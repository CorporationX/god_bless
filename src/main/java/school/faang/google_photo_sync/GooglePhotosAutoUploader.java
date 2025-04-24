package school.faang.google_photo_sync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    private void uploadPhotos() {
        synchronized (lock) {
            for (String photo : photosToUpload) {
                log.info("Фотография {} загружена", photo);
            }
            photosToUpload.clear();
        }
    }

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("ОШибка при ожидании: {}", e.getMessage());
                        throw new RuntimeException();
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
