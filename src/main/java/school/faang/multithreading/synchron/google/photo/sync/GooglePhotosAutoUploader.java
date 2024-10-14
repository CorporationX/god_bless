package school.faang.multithreading.synchron.google.photo.sync;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    @SneakyThrows
    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        System.out.println("Поток: " + Thread.currentThread().getName() + " добавил новые файлы на сервер:");
        photosToUpload.forEach(System.out::println);
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Поток: " + Thread.currentThread().getName() + " добавил новую фотографию: " + photoPath);
            lock.notify();
        }
    }
}
