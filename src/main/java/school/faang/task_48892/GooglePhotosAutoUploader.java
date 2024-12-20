package school.faang.task_48892;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(String.format("Загружено фото %s потоком %s. Количество незагруженных фото %d", photoPath, Thread.currentThread().getName(), photosToUpload.size()));
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.stream().forEach((photo) -> System.out.println(String
                    .format("Загрузка фото %s на сервер потоком %s", photo, Thread.currentThread().getName())));
            System.out.println("Все фото загружены.");
            photosToUpload.clear();
        }
    }
}
