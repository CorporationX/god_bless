package school.faang.task_48852;

import school.faang.exception.CheckException;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Произошла ошибка");
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        if (photoPath == null || photoPath.isEmpty()) {
            throw new CheckException("photoPath");
        }
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        System.out.println("Начало загрузки фотографий...");
        List<String> uploadedPhotos = new ArrayList<>();
        for (String photo : photosToUpload) {
            System.out.println("Загрузка фотографии: " + photo);
            uploadedPhotos.add(photo);
        }
        photosToUpload.clear();
        System.out.println("Загружен фотографий: " + uploadedPhotos.size());
    }
}
