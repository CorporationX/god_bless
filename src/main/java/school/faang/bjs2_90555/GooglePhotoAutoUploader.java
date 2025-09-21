package school.faang.bjs2_90555;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class GooglePhotoAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUploader = new ArrayList<>();

    public void startAutoUploader() {
        synchronized (lock) {
            while (photosToUploader.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("Выбросило исключение на ожидании потока {}", Thread.currentThread().getName());
                    Thread.currentThread().interrupt();
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        if (photoPath == null) {
            log.error("Фотография не может быть пустой");
            throw new IllegalArgumentException("PhotoPath not be null");
        }
        synchronized (lock) {
            log.info("Загрузка фотографии произведена, {}", photoPath);
            photosToUploader.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        List<String> uploadPhoto;
        synchronized (lock) {
            uploadPhoto = new ArrayList<>(photosToUploader);
        }
        for (String photo : uploadPhoto) {
            log.info("Фотография загружена на сервер {}", photo);
        }
        photosToUploader.clear();
    }
}
