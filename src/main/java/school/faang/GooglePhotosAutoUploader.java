package school.faang;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUploader = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUploader.isEmpty()) {
                    System.out.println("новых фото нет");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUploader.add(photoPath);
            System.out.println("добавлена новая фото" + photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        while (!photosToUploader.isEmpty()) {
            String photoPath = photosToUploader.remove(0);
            System.out.println("Загрузка фото" + photoPath);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
