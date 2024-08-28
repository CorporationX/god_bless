package faang.school.godbless.google_photo_sync;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final Object lock = new Object();

    private static List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            System.out.println("Зашли в метод startAutoUpload");
            while (true) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("Новых фоток нет - ждемс");

                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Новые фотки есть");
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.println("Зашли в метод onNewPhotoAdded");
            photosToUpload.add(photoPath);
            lock.notify();
            System.out.println("Уведомляем об освобождении лока");
        }
    }

    @SneakyThrows
    public void uploadPhotos() {
        System.out.println("Зашли в метод uploadPhotos - Загружаем фотки на гугл диск");
        Thread.sleep(1000);
        photosToUpload.clear();
    }
}
