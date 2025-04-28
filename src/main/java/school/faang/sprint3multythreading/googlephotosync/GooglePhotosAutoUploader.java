package school.faang.sprint3multythreading.googlephotosync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = Collections.synchronizedList(new ArrayList<>());

    public void startAutoUpload() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        log.info("Список фотографий пуст. Ожидание...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        log.error("Прерывание во время ожидания: {}", e.getMessage());
                        Thread.currentThread().interrupt();
                        break;
                    }
                }

                if (!photosToUpload.isEmpty()) {  // Дополнительная проверка
                    uploadPhotos();
                }
            }

            if (Thread.currentThread().isInterrupted()) {
                log.info("Завершение работы из-за прерывания потока");
                break;
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(ph -> log.info("Фотография {} загружена на сервер.\n", ph));
        photosToUpload.clear();
        log.info("Список фотографий для загрузки очищен.");
    }
}