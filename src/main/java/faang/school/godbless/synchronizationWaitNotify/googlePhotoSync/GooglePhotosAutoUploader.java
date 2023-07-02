package faang.school.godbless.synchronizationWaitNotify.googlePhotoSync;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload;
    private boolean isContinue;

    public GooglePhotosAutoUploader() {
        this.photosToUpload = new ArrayList<>();
        isContinue = true;
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (isContinue) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            photosToUpload.add(photoPath);
            System.out.println("Добавлено фото " + photoPath);
            lock.notify();
        }
    }

    public void stopUploading() {
        synchronized (lock) {
            isContinue = false;
            //чтобы все потоки проснулись
            lock.notify();
        }
    }

    private void uploadPhotos() {
        if (photosToUpload.isEmpty()) {
            return;
        }
        photosToUpload.forEach((photo) -> {
            System.out.println("Загрузка фото " + photo);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        photosToUpload.clear();
    }
}
