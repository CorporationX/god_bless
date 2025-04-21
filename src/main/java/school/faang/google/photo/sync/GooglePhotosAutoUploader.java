package school.faang.google.photo.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    public void startAutoUpload() {
        synchronized (lock) {
            try {
                while (true) {
                    if (photosToUpload.isEmpty()) {
                        log.info("Ожидание...");
                        lock.wait();
                    } else {
                        uploadPhotos();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Поток загрузки был прерван.");
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Добавлена новая фотография: {}", photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        log.info("Загрузка фотографий...");
        for (String photo : photosToUpload) {
            try {
                log.info("Загрузка файла: {}", photo);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Загрузка прервана.");
                return;
            }
        }
        photosToUpload.clear();
        log.info("Все фотографии загружены.");
    }
}
