package google_photo_sync;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    @SneakyThrows
    public void startAutoUpload() {
        while (photosToUpload.isEmpty()) {
        synchronized (lock) {
            System.out.println("Жду фотографию");
            lock.wait();
        }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("добавил фотографию для загрузки!");
            lock.notify();
        }
    }

    private void uploadPhotos() {
            System.out.println("Фотография в облаке, вауууууууу!");
            photosToUpload.clear();
    }
}
