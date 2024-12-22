package school.faang.sprint_3.task_43561;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                System.out.println("Нет фото для загрузки. Ожидаем...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Поток был прерван во время ожидания");
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            System.out.println("Загружаем фото на сервер: " + photosToUpload);
            photosToUpload.clear();
        }
    }
}
