package school.faang.task_48960;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock;
    private final List<String> photosToUpload;


    public GooglePhotosAutoUploader() {
        this.photosToUpload = new ArrayList<>();
        this.lock = new Object();
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                    log.info("Ожидание фото для загрузки...");
                } catch (InterruptedException e) {
                    log.error("Произошло исключение при выполнении метода wait()", e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        if (photoPath == null || photoPath.isEmpty()) {
            log.info("Фото не может быть загружено, так как указан некорректный путь к нему");
            return;
        }

        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Фото {} добавлено в список для загрузки", photoPath);
            lock.notifyAll();
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            log.info("Загружаем на сервер фото {}...", photo);
        }
        photosToUpload.clear();
        log.info("Фотографии загружены на сервер!");
        lock.notify();
    }
}
