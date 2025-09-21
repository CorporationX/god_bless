package school.faang.bjs2_90393;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public synchronized void startAutoUpload() {
        while (photosToUpload.isEmpty()) {
            try {
                this.wait();
                log.info("Отправляю фотографии на сервер...");
                uploadPhotos();
            } catch (InterruptedException e) {
                log.info("Меня прервали во время ожидания");
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        this.notify();
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            log.info("На сервер отправлена фотография {}", photo);
        }
        photosToUpload.clear();
    }
}