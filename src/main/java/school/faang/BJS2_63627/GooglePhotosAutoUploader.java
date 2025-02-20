package school.faang.BJS2_63627;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    protected void startAutoUpload() {
        log.info("Поток запустил Автоматическую загрузку фотографий");
        while (true) {
            synchronized (photosToUpload) {
                while (photosToUpload.isEmpty()) {
                    try {
                        photosToUpload.wait();
                    } catch (InterruptedException e) {
                        log.error("Поток был прерван во время ожидания загрузки фотографий");
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                uploadPhotos();
                log.info("Ждем добавления новых фотографий....");
            }
        }
    }

    protected void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }
    }

    protected void uploadPhotos() {
        for (String photo : photosToUpload) {
            log.info("Загружаем фотографию " + photo);
        }
        photosToUpload.clear();
    }
}