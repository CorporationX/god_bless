package mod1sp3.googlePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new IllegalStateException("Wait method error" + e.getMessage(), e);
                }
                uploadPhotos();
            } else {
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавили в папку фото " + photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        System.out.print("Загрузка фото на сервер... \n ...фото загружены на сервер");
    }
}
