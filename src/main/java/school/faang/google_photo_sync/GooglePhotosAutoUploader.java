package school.faang.google_photo_sync;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Проект: god_bless
 * Класс GooglePhotosAutoUploader
 * Автор: Vital
 */

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();

    @Getter
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            List<String> photosCopy;

            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        log.info("Список фотографий пуст. Ждем новые фото...");
                        lock.wait(); //ждем появления новых фотографий
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("Поток был прерван", e);
                        return;
                    }
                }
                photosCopy = new ArrayList<>(photosToUpload);
            }
            uploadPhotos(photosCopy);
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        if (Objects.isNull(photoPath) || photoPath.isBlank()) {
            log.warn("Путь к фотографии пустой, пропускаем добавление.");
            return;
        }

        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Добавлена новая фотография: {}", photoPath);
            lock.notify(); //уведомляем поток о новой фотографии
        }
    }

    private void uploadPhotos(List<String> photos) {
        photos.stream()
                .filter(Objects::nonNull)
                .forEach(photo -> log.info("Загружаем фотографию: {}", photo));

        synchronized (lock) {
            photosToUpload.removeAll(photos);
        }
    }
}