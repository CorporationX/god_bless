package school.faang.task48853;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosAutoUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosAutoUpload.isEmpty()) {
                try {
                    log.info("Список фото пуст");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток был прерван во время ожидания {}", e.getMessage());
                }
            }
            uploadPhotos();
        }

    }

    public void onNewPhotoAdded(String photoPath) {
        if (photoPath == null || photoPath.isBlank()) {
            throw new IllegalArgumentException("photoPath can`t be null");
        }

        synchronized (lock) {
            log.info("Добавление новой фотографии");

            photosAutoUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        log.info("Происходит загрузка фотографий на сервер...");

        photosAutoUpload.forEach(log::info);
        photosAutoUpload.clear();
    }
}
