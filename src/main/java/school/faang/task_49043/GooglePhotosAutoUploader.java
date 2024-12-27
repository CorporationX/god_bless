package school.faang.task_49043;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        System.out.println("Загрузка фотографий на сервер");
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("Ожидание фоток");
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Загрузка фотографии " + photo);
        }
        photosToUpload.clear();
    }
}
