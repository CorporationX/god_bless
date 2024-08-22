package google.photo.sync;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final static int UPLOAD_DELAY = 2000;
    private final static int ADD_PHOTO_DELAY = 1000;
    private final Object lock = new Object();
    @Getter
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (!Thread.currentThread().isInterrupted()) {
                lock.wait();
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() throws InterruptedException {
        for (String photo : this.photosToUpload) {
            System.out.printf("Загружаем фотографию %s на сервер\n", photo);
            Thread.sleep(UPLOAD_DELAY);
        }

        this.photosToUpload.clear();
    }

    public void onNewPhotoAdded(GooglePhoto photo) throws InterruptedException {
        synchronized (lock) {
            this.photosToUpload.add(photo.getPhotoPath());
            System.out.printf("Добавлено новое фото %s для загрузки на сервер\n", photo.getPhotoPath());
            lock.notify();
            Thread.sleep(ADD_PHOTO_DELAY);
        }
    }
}
