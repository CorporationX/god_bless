package faang.school.godbless.BJS224437;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object(); // Объект для синхронизации потоков
    private final List<String> photosToUpload = new ArrayList<>();  // Список фотографий для загрузки

    public void startAutoUpload() {
        synchronized (lock) {
            if (!Thread.currentThread().isInterrupted()) {
                try {
                    while (photosToUpload.isEmpty()) {
                        System.out.println("No photos to upload. Waiting...");
                        lock.wait();
                    }
                    uploadPhotos();
                } catch (InterruptedException e) {
                    System.out.println("Auto upload interrupted");
                    Thread.currentThread().interrupt(); // Восстанавливаем флаг прерывания
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("New photo added: " + photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        if (!photosToUpload.isEmpty()) {
            String photoPath = photosToUpload.remove(0);
            System.out.println("Uploading photo: " + photoPath);
            try {
                Thread.sleep(1000); // Симулируем время загрузки фотографии
            } catch (InterruptedException e) {
                System.out.println("Upload interrupted");
                Thread.currentThread().interrupt(); // Восстанавливаем флаг прерывания
                return;
            }
        } else {
            System.out.println("No photos to upload");
        }
        System.out.println("All photos uploaded");
    }
}
