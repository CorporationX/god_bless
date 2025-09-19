package school.faang.bjs2_92485;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    private boolean hasPhoto = false;

    public void startAutoUpload() {
        synchronized (lock) {
            if (hasPhoto) {
                // вызов uploadPhoto
                System.out.println("Фото загруженно");
            } else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            hasPhoto = false;
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            hasPhoto = true;
            lock.notify();
        }
    }

    public void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.printf("Загружаем фото: %s%n", photo);
        }
        photosToUpload.clear();
    }
}
