package school.faang.task_63811;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {

    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();
    private boolean isRunning = true;

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    if (!isRunning) {
                        break;
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("Поток загрузки прерван: {}", e.getMessage());
                        return;
                    }
                }
                uploadPhotos();
            }
        }
        log.info("Загрузка завершена.");
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void stopAutoUpload() {
        synchronized (lock) {
            isRunning = false;
            lock.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> log.info("Загружается: {}", photo));
        photosToUpload.clear();
    }
}