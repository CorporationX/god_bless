package school.faang.synchronized__notify.bjs2_90366;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static school.faang.synchronized__notify.bjs2_90366.Utils.runWithThreadErrorHandling;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            runWithThreadErrorHandling(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    while (photosToUpload.isEmpty()) {
                        log.info("Список фото пуст, поток ждет");
                        lock.wait();
                        log.info("В списке появились path к фото, поток продолжил работу");
                    }
                    uploadPhotos();
                }
            });
        }
    }

    private void uploadPhotos() {
        log.info("ОТПРАВЛЯЮ ФАЙЛЫ НА СЕРВЕР");
        photosToUpload.forEach(path -> log.info("Фото: {} загружена на сервер", path));
        photosToUpload.clear();
        log.info("ФАЙЛЫ ОТПРАВЛЕНЫ");
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();

        }
    }
}