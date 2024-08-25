package faang.school.godbless.BJS2_24560;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private boolean running = true;

    public void startAutoUpload() {
        while (running) {
            synchronized (lock) {
                try {
                    while (photosToUpload.isEmpty() && running) {
                        System.out.println("Ждем новых фотографий...");
                        lock.wait();
                    }
                    if (!running) {
                        break;
                    }
                    uploadPhotos();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Поток был прерван.");
                    break;
                }
            }
        }
        System.out.println("Процесс авто-загрузки завершен.");
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлена новая фотография: " + photoPath);
            lock.notifyAll();
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.forEach(photo -> {
                System.out.println("Загрузка фотографии: " + photo);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Фото " + photo + " загружено!");
            });
            photosToUpload.clear();
        }
    }
    public void stopAutoUpload() {
        running = false;
        synchronized (lock) {
            lock.notifyAll();
        }
    }
}
