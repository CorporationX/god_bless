package school.faang.googlephotosync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                photosToUpload.wait();
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Добавление фотографии - {} в список", photoPath);
            photosToUpload.notify();
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            for (String photo : photosToUpload) {
                log.info("Загрузки фотографии - {}, на сервер", photo);
            }
            photosToUpload.clear();
            log.info("Очистка списка");
        }
    }
}
