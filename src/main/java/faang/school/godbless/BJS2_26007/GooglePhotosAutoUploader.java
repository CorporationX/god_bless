package faang.school.godbless.BJS2_26007;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException exception) {
                        Thread.currentThread().interrupt();
                        System.out.println(exception.getMessage());
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
            System.out.println("Новая фотография добавлена во временное хранилище: " + photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        while (!photosToUpload.isEmpty()) {
            String photoPath = photosToUpload.remove(0);
            System.out.println("Загрузка фото, путь: " + photoPath);
        }
    }
}
