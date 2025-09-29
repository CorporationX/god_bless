package school.faang.google_photo_sync_bjs2_90475;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    Boolean bolean = true;

    public void startAutoUpload() {
        synchronized (lock) {
            while (bolean) {
                try {
                    uploadPhotos();
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            bolean = true;
            System.out.println(Thread.currentThread().getName() + " Добовляем фотки");
            lock.notify();
        }
    }

    public void uploadPhotos() {
        photosToUpload.stream()
                .forEach(e -> System.out.println(Thread.currentThread().getName() + " Загружаем фотки"));
        photosToUpload.clear();
        bolean = false;
    }
}
