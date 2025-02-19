package school.faang.googlephotosync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            try {
                if (photosToUpload.isEmpty()) {
                    log.info("Фотографий для загрузки пока нет.");
                    lock.wait();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Добавлена новая фотография: {}",
                    photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            log.info("Происходит процесс выгрузки фотографии на сервер: {}",
                    photoPath);
        }
        photosToUpload.clear();
        log.info("Выгрузка фотографий завершена");
    }
}
