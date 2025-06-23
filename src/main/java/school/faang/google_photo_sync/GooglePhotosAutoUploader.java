package school.faang.google_photo_sync;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    System.out.println("Нет фото для обработки");
                    lock.wait();
                } catch (InterruptedException ignored) {
                    throw new RuntimeException("Time out");
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлены фото в очередь");
            lock.notify();
            System.out.println("Уведомили что появились фото в очереди");
        }
    }

    public void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Загружаем фотографию: " + photo);
        }
        photosToUpload.clear();
    }
}