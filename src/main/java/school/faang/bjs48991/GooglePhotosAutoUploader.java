package school.faang.bjs48991;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock;
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        lock = new Object();
        photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    log.info("Waiting because no photos");
                    lock.wait();
                }
            }
            log.info("Been notified or there was photos");
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        synchronized (photosToUpload) {
            photosToUpload.forEach(photo -> log.info("Photo {} delivered to server", photo));
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String path) {
        synchronized (lock) {
            photosToUpload.add(path);
            lock.notify();
            log.info("Added photo {} and notified", path);
        }
    }
}
