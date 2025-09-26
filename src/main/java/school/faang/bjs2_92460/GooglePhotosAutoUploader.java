package school.faang.bjs2_92460;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public synchronized void startAutoUpload() {
        try {
            while (photosToUpload.isEmpty()) {
                wait();
            }
            Thread.sleep(10_000);
            uploadPhotos();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        System.out.printf("Фото %s добавлено в список на загрузку%n", photoPath);
        notify();
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
