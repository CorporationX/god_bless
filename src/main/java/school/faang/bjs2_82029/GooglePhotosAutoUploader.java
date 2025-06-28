package school.faang.bjs2_82029;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader(List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
    }

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException();
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            for (String photoPath : photosToUpload) {
                log.info("Uploading {}...", photoPath);
            }
            photosToUpload.clear();
        }
    }
}
