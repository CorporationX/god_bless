package school.faang.task_61802;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            while (photosToUpload.isEmpty()) {
                try {
                    photosToUpload.wait();
                } catch (InterruptedException e) {
                    System.out.println("Загрузка фотографий прервана");
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(@NonNull String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.printf("Фотография \"%s\" загружена на сервер%n", photo));
        photosToUpload.clear();
    }
}
