package school.faang.google_photo_sync;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Slf4j
public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private final String uploaderName;

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                try {
                    while (photosToUpload.isEmpty()) {
                        log.info("{}: Нет фотографий для загрузки. Ожидаем добавления новых...", uploaderName);
                        lock.wait();
                    }
                    log.info("{}: Обнаружены новые фотографии. Начинаем загрузку...", uploaderName);
                    uploadPhotos();
                } catch (InterruptedException e) {
                    log.warn("{}: Загрузка прервана!", uploaderName);
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("{}: Добавлена новая фотография: {}", uploaderName, photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            for (String photoPath : photosToUpload) {
                log.info("{}: Загружаем фотографию: {}", uploaderName, photoPath);
                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500) + 200);
                } catch (InterruptedException e) {
                    log.warn("{}: Загрузка фотографии {} прервана", uploaderName, photoPath);
                    Thread.currentThread().interrupt();
                }
                log.info("{}: Фотография {} успешно загружена.", uploaderName, photoPath);
            }
            photosToUpload.clear();
        }
    }
}