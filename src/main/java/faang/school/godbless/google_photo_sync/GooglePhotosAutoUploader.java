package faang.school.godbless.google_photo_sync;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (!photosToUpload.isEmpty()) {
                    uploadPhotos();
                } else if (photosToUpload.isEmpty()) {
                    System.out.println("Фотографии отсутствуют!");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Новая фотография " + photoPath + " добавлена!");
            lock.notify();
        }
    }

    public void uploadPhotos() {
        System.out.println("Загрузка фотографий на сервер...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Загрузка завершена");
        photosToUpload.clear();
    }
}
