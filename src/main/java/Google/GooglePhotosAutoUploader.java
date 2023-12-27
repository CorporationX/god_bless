package Google;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();

    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                } else {
                    uploadPhotos();
                    break;
                }
            }
        }
    }

    public void uploadPhotos() throws InterruptedException {
        for (String photoPath : photosToUpload) {
            System.out.println("Фото загружено на сервер");
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Фото добавлено в список загрузок");
            lock.notify();
        }

    }
}
