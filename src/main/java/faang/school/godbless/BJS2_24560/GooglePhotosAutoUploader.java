package faang.school.godbless.BJS2_24560;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                try {
                    while (photosToUpload.isEmpty()) {
                        System.out.println("Ждем новых фотографий...");
                        lock.wait();
                    }
                    uploadPhotos();
                } catch (InterruptedException e) {
                    System.out.println("Произошла ошибка" + e);
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлена новая фотография: " + photoPath);
            lock.notifyAll();
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.forEach(photo -> {
                System.out.println("Загрузка фотографии: " + photo);
                try {
                    Thread.sleep(3000);
                    System.out.println("Фото " + photo + " загружено!");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Процесс загрузки был прерван.");
                }
            });
            photosToUpload.clear();
        }
    }
}
