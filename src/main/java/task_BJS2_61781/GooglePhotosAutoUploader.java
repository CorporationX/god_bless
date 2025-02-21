package task_BJS2_61781;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            do {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException exception) {
                        Thread.currentThread().interrupt();
                        log.info("Thread: {} was interrupted", Thread.currentThread().getName());
                    }
                }
                uploadPhotos();
            } while (System.currentTimeMillis() < 100_000);
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.printf("Фото: \"%s\" - загружено на сервер\n", photo));
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
