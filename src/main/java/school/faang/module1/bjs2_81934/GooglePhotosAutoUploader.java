package school.faang.module1.bjs2_81934;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload;
    private boolean isRunning = true;

    public void startAutoUpload() {
        while (isRunning) {
            synchronized (lock) {
                while (photosToUpload.isEmpty() && isRunning) {
                    try {
                        log.info("Нет новых фото. Ожидание...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("Поток прерван", e);
                        return;
                    }
                }
                uploadPhotos();
            }
        }
        log.info("Загрузчик остановлен.");
    }

    public void uploadPhotos() {
        photosToUpload.forEach(s -> log.info("Новое фото загружено: {}", s));
        photosToUpload.clear();
        log.info("Все фото успешно загружены и очищены из списка.");
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Добавлено новое фото {}", photoPath);
            lock.notify();
        }
    }

    public void stop() {
        synchronized (lock) {
            isRunning = false;
            lock.notify();
        }
    }
}