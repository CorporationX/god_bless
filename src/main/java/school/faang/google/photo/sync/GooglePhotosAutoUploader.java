package school.faang.google.photo.sync;

import java.util.LinkedList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new LinkedList<>();
    private final Object lock = new Object();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("Ожидание новых фотографий...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
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

    private void uploadPhotos() {
        System.out.println("Начинается загрузка фотографий...");
        while (!photosToUpload.isEmpty()) {
            String photo = photosToUpload.remove(0);
            System.out.println("Загружена фотография: " + photo);
        }
        System.out.println("Все фотографии загружены!");
    }
}