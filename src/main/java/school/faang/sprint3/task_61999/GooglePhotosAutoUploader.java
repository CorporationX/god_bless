package school.faang.sprint3.task_61999;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();
    private int photosAdded;
    private int photosDownloaded;

    public void printResult() {
        log.debug("Добавлено {}, загружено {}, остались {}", photosAdded, photosDownloaded, photosToUpload);
    }

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        log.error("Поток прерван", e);
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photo) {
        synchronized (lock) {
            log.debug("Фото {} добавлено", photo);
            photosToUpload.add(photo);
            photosAdded++;
            lock.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(this::uploadPhoto);
        photosToUpload.clear();
    }

    private void uploadPhoto(String photo) {
        log.debug("Фото {} загружено", photo);
        photosDownloaded++;
    }
}
