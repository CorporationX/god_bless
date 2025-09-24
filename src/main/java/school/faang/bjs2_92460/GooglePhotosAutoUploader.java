package school.faang.bjs2_92460;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            try {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                } else {
                    uploadPhotos();
                    Thread.sleep(10_000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.printf("Фото %s добавлено в список на загрузку%n", photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        System.out.println("Загружаю фотографии на сервер...");
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        photosToUpload.clear();
    }
}
