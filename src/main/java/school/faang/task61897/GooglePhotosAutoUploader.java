package school.faang.task61897;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    log.info("Фотографий нет, ожидание..");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Error lock waiting", e);
                }
            }
            log.info("Фото найдены");
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(@NonNull String photoPath) {
        synchronized (lock) {
            log.info("Добавлен новый путь");
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            log.info("Фото загружены");
            photosToUpload.clear();
        }
    }
}
