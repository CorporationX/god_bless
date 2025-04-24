package school.faang.bjs2_73680;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = Collections.synchronizedList(new ArrayList<>());
    private volatile boolean isRun = true;

    public void startAutoUpload() {
        while (isRun()) {
            synchronized (this.lock) {
                if (this.photosToUpload.isEmpty() && isRun) {
                    try {
                        log.info("wait into startAutoUpload()");
                        this.lock.wait();
                    } catch (InterruptedException e) {
                        log.error("error in auto upload method: {}", e.getMessage(), e);
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoName) {
        synchronized (this.lock) {
            this.photosToUpload.add(photoName);
            log.info("photo {} was loaded.", photoName);
            this.lock.notify();
        }
    }

    public boolean isRun() {
        synchronized (this) {
            return isRun;
        }
    }

    public void stop() {
        synchronized (this) {
            isRun = false;
        }
        synchronized (this.lock) {
            this.lock.notify();
        }
    }

    private void uploadPhotos() {
        this.photosToUpload.forEach(photoPath -> log.info("photo {} was upload", photoPath));
        this.photosToUpload.clear();
    }
}
