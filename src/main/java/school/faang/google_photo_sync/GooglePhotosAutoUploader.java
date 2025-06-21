package school.faang.google_photo_sync;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object look = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    @SneakyThrows
    public void startAutoUpload() {
        synchronized (look) {
            if (photosToUpload.isEmpty()) {
                System.out.println("Нет фото для загрузки");
                look.wait();
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (look) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлены фото в очередь");
            look.notify();
            System.out.println("Уведомили что появились фото в очереди");
        }
    }

    public void uploadPhotos() {
        System.out.println("Фотографии загружены");
        photosToUpload.clear();
    }
}
