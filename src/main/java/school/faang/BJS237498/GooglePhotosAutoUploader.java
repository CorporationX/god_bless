package school.faang.BJS237498;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("Фоток нет");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
         synchronized (lock) {
             photosToUpload.add(photoPath);
             System.out.println("Путь добавлен");
             lock.notify();
         }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.println("Загружаю фотографию " + photo));
        System.out.println("Удаляю фотографии");
        photosToUpload.clear();
    }
}
