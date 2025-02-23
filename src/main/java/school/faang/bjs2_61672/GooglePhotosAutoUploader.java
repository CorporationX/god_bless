package school.faang.bjs2_61672;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();
    private volatile boolean running = true;

    public void stop() {
        synchronized (lock) {
            running = false;
            lock.notifyAll();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("New photo added: {}", photoPath);
            lock.notify();
        }
    }

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty() && running) {
                    try {
                        log.info("No new photos. Waiting...");
                        lock.wait(); // Ждём, пока появятся новые фото
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.warn("Uploader thread interrupted.", e);
                        return;
                    }
                }
                if (!running) {
                    log.info("Uploader stopped.");
                    return;
                }
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            log.info("Uploading {} photo(s) to server...", photosToUpload.size());
            try {
                Thread.sleep(2000); // Симуляция загрузки
                log.info("Upload completed.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Upload interrupted.", e);
            }
            photosToUpload.clear();
        }
    }
}