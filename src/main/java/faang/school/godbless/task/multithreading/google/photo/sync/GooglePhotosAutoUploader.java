package faang.school.godbless.task.multithreading.google.photo.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Lock lock = new Lock();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        log.info("Начата автозагрузка фотографий в облако");
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    log.info("Список фотографий пуст, автозагрузка приостановлена");
                    try {
                        lock.wait();
                    } catch (InterruptedException exception) {
                        log.error("Interrupted exception: {}", exception.getMessage());
                    }
                } else {
                    log.info("В списке новые фото, автозагрузка возобновлена");
                    uploadPhotos();
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            log.info("В список добавлено фото: {}", photoPath);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(photo -> {
            log.info("Фото {} загружено в облако", photo);
        });
        photosToUpload.clear();
    }
}
