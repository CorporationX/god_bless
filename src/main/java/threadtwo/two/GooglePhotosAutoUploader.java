package threadtwo.two;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private static Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("Список фото на загрузку пуст.");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Обработка фото прервана.");
                        return;
                    }
                }
                System.out.println("Обработка фото началась.");
                uploadPhotos();
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
