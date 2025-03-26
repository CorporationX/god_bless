package school.faang.task_61829;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (photosToUpload) {
                while (photosToUpload.isEmpty()) {
                    try {
                        photosToUpload.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("Поток был прерван!");
                        return;
                    }
                }
                uploadPhotos();
                log.info("Очередь на загрузку пуста! Ожидание добавления новых фотографий");
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
            log.info("Фото добавлено в библиотеку");
        }
    }

    public void uploadPhotos() {
        synchronized (photosToUpload) {
            for (String photoPath : new ArrayList<>(photosToUpload)) {
                log.info("Фото {} загружено на сервер", photoPath);
                photosToUpload.clear();
            }
            log.info("Все фотографии загружены.");
        }
    }
}
