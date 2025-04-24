package school.faang.bjs273692;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Загружаю " + photo);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
        photosToUpload.clear();
        System.out.println("Фото загружены");
    }

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("Все фото уже загружены");
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("InterruptedException");
                        return;
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлена новая фотография: " + photoPath);
            lock.notify();
        }
    }
}
