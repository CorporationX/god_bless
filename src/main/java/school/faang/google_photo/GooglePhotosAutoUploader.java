package school.faang.google_photo;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Setter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();
    private final long waitingTime = 5L;
    private int limit = 15;

    public void startAutoUpload() {
        synchronized (lock) {
            while (limit > 0) {
                if (photosToUpload.isEmpty()) {
                    log.info("Список пуст , ожидаем");
                    try {
                        limit--;
                        lock.wait(waitingTime);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    uploadPhotos();
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Появились новые фото для загрузки");
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            log.info("Фото {} загружено на сервер", photosToUpload.get(0));
            try {
                Thread.sleep(waitingTime);
            } catch (Exception e) {
                log.error("Ошибка загрузки фото :{}", e.getMessage());
            }
            photosToUpload.remove(0);
        }

    }
}
