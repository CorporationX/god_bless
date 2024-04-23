package faang.school.godbless.google_photo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GooglePhotosAutoUploader {
    private final Lock lock = new ReentrantLock();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    uploadPhotos();
                }
            }
        }
    }

    public void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Загрузка фотографии: " + photo);
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        synchronized (lock) {
            lock.notify();
        }
    }

    public void viewPhotos() {
        System.out.println("Показ фотографии:");
        for (String photo : photosToUpload) {
            System.out.println("Фото: " + photo);
        }
    }
}