package school.faang.google_photo_sync_bjs2_90475;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    Boolean flag = true;

    public void startAutoUpload() {
        while (flag) {
            synchronized (lock) {
                while (flag && photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
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
            flag = true;
            System.out.println(Thread.currentThread().getName() + " Добовляем фотки");
            lock.notify();
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(e -> System.out.println(Thread.currentThread().getName() + " Загружаем фотки"));
        photosToUpload.clear();
    }

    public void stopFlag() {
        synchronized (lock) {
            flag = false;
            lock.notify();
        }
    }
}
