package school.faang.bjs2_90412;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток авто-загрузки прерван", e);
                }
            }

            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        List<String> toUpload;

        synchronized (lock) {
            toUpload = new ArrayList<>(photosToUpload);
            photosToUpload.clear();
        }

        for (String photoPath : toUpload) {
            log.info("Загрузка фотографии - {}", photoPath);
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Добавлена фотография - {}", photoPath);
            lock.notify();
        }
    }
}
