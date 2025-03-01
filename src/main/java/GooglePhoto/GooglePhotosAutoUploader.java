package GooglePhoto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                System.out.println("Нет фотографий для загрузки. Ожидание новых фотографий...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.err.println("Поток загрузки прерван: " + e.getMessage());
                    Thread.currentThread().interrupt();
                    return;

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
        for (String photo : photosToUpload) {
            System.out.println("Загружаем фото: " + photo);
        }
        photosToUpload.clear();
    }
}
