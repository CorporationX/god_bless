package faang.school.godbless.thirdsprint.googlephotosync;

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
                            System.out.println("Нет новых фотографий, ожидание...");
                            lock.wait(10000);

                            if (photosToUpload.isEmpty()) {
                                System.out.println("Загрузка прервана из-за отсутствия" +
                                        " новых фотографий в течение 10 секунд.");
                                return;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлена новая фотография: " + photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        String photo = photosToUpload.remove(0);
        System.out.println("Загрузка фотографии: " + photo);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Процесс загрузки прерван.");
            return;
        }
        System.out.println("Фотография загружена: " + photo);
    }
}
