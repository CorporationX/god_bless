package school.faang.googlephotosync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public synchronized void startAutoUpload() {
        while (photosToUpload.isEmpty()) {
            try {
                System.out.println("Фото для загрузки нет, давай подождём, пока они появятся");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Фотографии загружаются");
        uploadPhotos();
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        if (photoPath == null) {
            throw new IllegalArgumentException("Добавь путь к фото");
        }
        photosToUpload.add(photoPath);
        notify();
    }

    public synchronized void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.printf("Фото %s загружено на сервер \n", photo));
        photosToUpload.clear();
    }

}