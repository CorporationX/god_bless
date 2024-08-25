package threadtwo.two;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private static Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                try {
                    if (photosToUpload.isEmpty()) {
                        lock.wait();
                        System.out.println("Список фото на загрузку пуст.");
                    } else {
                        System.out.println("Обработка фото началась.");
                        uploadPhotos();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Обработка фото прервана.");
                    return;
                }
            }
        }
    }

    public void onNewPhotoAdded(@NonNull String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            System.out.println("Фото загружено в облако.");
            photosToUpload.clear();
        }
    }
}
