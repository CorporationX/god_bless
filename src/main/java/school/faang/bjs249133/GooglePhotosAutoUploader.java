package school.faang.bjs249133;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        this.photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                    System.out.println("Ждем, пока не будут добавлены фотографии");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath); // Добавляем путь к фотографии в список
            lock.notify(); // Уведомляем поток, что появились новые фотографии
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(v -> System.out.println("Загружает фотографии на сервер: " + v));
        photosToUpload.clear();

    }
}
