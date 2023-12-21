package Google;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();

    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        while (true) {
            if (photosToUpload.isEmpty()) {
                Thread.sleep(500);
            } else {
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() throws InterruptedException {
        synchronized (lock) {
            for (String photoPath : photosToUpload) {
                System.out.println("Фото загружено на сервер");
            }
            photosToUpload.clear();
            lock.wait();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Фото добавлено в список загрузок");
            lock.notify();
        }

    }
}
