package school.faang.task_63811;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {

    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();
    private volatile boolean isRunning = true;

    public void startAutoUpload() {
        while (true) {
            List<String> batch;
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
                batch = new ArrayList<>(photosToUpload);
                photosToUpload.clear();
            }
            uploadPhotos(batch);
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

    private void uploadPhotos(List<String> photos) {
        photos.forEach(photo -> log.info("Загружается: {}", photo));
    }
}
