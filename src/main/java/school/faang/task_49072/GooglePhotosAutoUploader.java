package school.faang.task_49072;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload;
    private final Object lock;

    public GooglePhotosAutoUploader() {
        photosToUpload = new ArrayList<>();
        lock = new Object();
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    System.out.println("[" + Thread.currentThread().getName()
                            + "] Нет фотографий для загрузки. Ожидание...");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("[" + Thread.currentThread().getName()
                            + "] Поток был прерван, прерывание загрузки.");
                }
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        while (!photosToUpload.isEmpty()) {
            String photo = photosToUpload.remove(0);
            System.out.println("Загрузка фотографии: " + photo);
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлена новая фотография: " + photoPath);
            lock.notify();
        }
    }
}
