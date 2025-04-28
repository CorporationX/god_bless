package school.faang.bjs2_73721;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {

    private static final int UPLOAD_WAIT = 3000;
    public final Object lock = new Object();

    private final List<String> photosToUpload = new ArrayList<>();
    private static boolean working = true;

    public static void turnOff() {
        working = false;
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (working) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait(UPLOAD_WAIT);
                    } catch (InterruptedException e) {
                        log.info("Thread {} has been interrupted", Thread.currentThread().getName());
                        Thread.currentThread().interrupt();
                    }
                } else {
                    uploadPhotos();
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            log.info("Added new image -> {}", photoPath);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> log.info("Uploaded new image ({}) to server", photo));
        photosToUpload.clear();
    }


}
