package school.faang.googlephoto;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();

    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                log.info("Нет фотографий для загрузки");
                lock.wait();
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        validatePhotoPath(photoPath);
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Путь к фотографии добавлен");
            lock.notify();
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            log.info("Загрузка фотографий на сервер");
            photosToUpload.clear();
        }
    }

    private void validatePhotoPath(String path) {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Путь к фото не может быть пустым");
        }
    }
}