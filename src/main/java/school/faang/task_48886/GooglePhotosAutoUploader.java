package school.faang.task_48886;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {

    private static final Object LOCK = new Object();
    @Getter
    private static final List<String> photosToUpload = new ArrayList<>();

    public static void startAutoUpload() {
        synchronized (LOCK) {
            if (photosToUpload.isEmpty()) {
                try {
                    log.info("Тут пока ничего нет. Ожидаем добавления фотографий");
                    LOCK.wait();
                } catch (InterruptedException e) {
                    log.error("Автоматическая загрузка прервана с ошибкой: {}", e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
            uploadPhotos(photosToUpload);
        }
    }

    public static void onNewPhotoAdded(String photoPath) {
        synchronized (LOCK) {
            photosToUpload.add(photoPath);
            log.info("Фото добавлено в очередь на скачивание: {} .jpg", photoPath);
            LOCK.notify();
        }
    }

    public static void uploadPhotos(List<String> photosToUpload) {
        for (String photos : photosToUpload) {
            log.info("Загрузка фото в облачный сервис: {} .jpg ", photos);
        }
        photosToUpload.clear();
    }
}