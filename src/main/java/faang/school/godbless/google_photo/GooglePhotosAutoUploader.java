package faang.school.godbless.google_photo;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GooglePhotosAutoUploader {
    private final Lock lock = new ReentrantLock();
    private final List<String> photosToUpload = new ArrayList<>();

    @SneakyThrows
    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                lock.wait();
            } else {
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Загрузка фотографии: " + photo);
        }
        photosToUpload.clear();
    }

    private void onNewPhotoAdded(String photoPath) {
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