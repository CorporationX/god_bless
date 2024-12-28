package school.faang.task_48968;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final Object lock = new Object();
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader(List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
    }

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Ошибка");
                }
            } else {
                System.out.println("Загрузка фото");
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            try {
                lock.notify();
            } catch (IllegalMonitorStateException e2) {
                System.out.println("Ошибка");
            }
        }
    }

    public void uploadPhotos() {
        System.out.println("Фотографии загружены на сервер");
        photosToUpload.clear();
    }
}
