package school.faang.bjs2_90426;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    public final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        log.info("Нет новых фотографий. Ожидание...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("Загрузка фотографий прервана", e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        List<String> toUpload;

        synchronized (lock) {
            toUpload = new ArrayList<>(photosToUpload);
            photosToUpload.clear();
        }
        log.info("📤 Начинаем загрузку {} фотографий", toUpload.size());

        toUpload.forEach(photo -> log.info("Фотография загружена: {}", photo));
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Добавлена новая фотография: {}", photoPath);
            lock.notify();
        }
    }
}

