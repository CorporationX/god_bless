package school.faang.task61897;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    log.info("Фотографий нет, ожидание..");
                    lock.wait();
                } catch (InterruptedException e) {
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

    public void uploadPhotos() {
        synchronized (lock) {
            log.info("Фото загружены");
            photosToUpload.clear();
        }
    }
}
