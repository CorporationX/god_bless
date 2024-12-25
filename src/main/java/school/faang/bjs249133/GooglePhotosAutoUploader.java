package school.faang.bjs249133;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final Object lock;
    private final List<String> photosToUpload;
    @Setter
    private boolean isServiceTurnOn;

    public GooglePhotosAutoUploader() {
        this.photosToUpload = new ArrayList<>();
        this.lock = new Object();
        this.isServiceTurnOn = true;
    }

    public void startAutoUpload() {
        while (isServiceTurnOn) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                        System.out.println("Ждем, пока не будут добавлены фотографии");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(v -> System.out.println("Загружает фотографии на сервер: " + v));
        photosToUpload.clear();

    }
}
