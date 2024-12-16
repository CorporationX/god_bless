package school.faang.task48853;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Logger logger = LoggerFactory.getLogger(GooglePhotosAutoUploader.class);

    private final Object lock = new Object();
    private final List<String> photosAutoUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosAutoUpload.isEmpty()) {
                try {
                    System.out.println("Список фото пуст");
                    lock.wait();
                } catch (InterruptedException e) {
                    logger.error(e.getMessage());
                }
            }
            uploadPhotos();
        }

    }

    public void onNewPhotoAdded(String photoPath) {
        if (photoPath == null) {
            throw new IllegalArgumentException("photoPath can`t be null");
        }

        synchronized (lock) {
            System.out.println("Добавление новой фотографии");
            photosAutoUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        System.out.println("Происходит загрузка фотографий на сервер...");
        photosAutoUpload.forEach(System.out::println);
        photosAutoUpload.clear();
    }
}
