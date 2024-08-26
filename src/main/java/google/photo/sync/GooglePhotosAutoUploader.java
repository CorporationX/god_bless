package google.photo.sync;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final static int UPLOAD_DELAY = 2000;
    private final static int ADD_PHOTO_DELAY = 1000;
    private final Object lock = new Object();
    @Getter
    private final List<String> photosToUpload = new ArrayList<>();
    @Setter
    private boolean autoupload = true;

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (autoupload) {
                if (this.photosToUpload.isEmpty()) {
                    lock.wait();
                }

                this.uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        this.photosToUpload.forEach(photo -> {
            System.out.printf("Загружаем фотографию %s на сервер\n", photo);
            try {
                Thread.sleep(UPLOAD_DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        this.photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) throws InterruptedException {
        synchronized (lock) {
            this.photosToUpload.add(photoPath);
            System.out.printf("Добавлено новое фото %s для загрузки на сервер\n", photoPath);
            Thread.sleep(ADD_PHOTO_DELAY);

            lock.notify();
        }
    }
}
