package school.faang.synchronization.bjs2_73641;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final Deque<String> photosToUpload = new ArrayDeque<>();

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            this.photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (this.photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.info("Thread interrupted!!!");
                    Thread.currentThread().interrupt();
                }
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            while (!photosToUpload.isEmpty()) {
                String photoPath = this.photosToUpload.pop();
                log.info("photo {} uploaded", photoPath);
            }
        }
    }
}
