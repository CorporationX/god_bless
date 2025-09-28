package school.faang.bjs2_90462;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private boolean isRunning = true;

    public void startAutoUpload() {
        while (isRunning) {
            synchronized (lock) {
                while (photosToUpload.isEmpty() && isRunning) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        log.warn("{} был прерван", Thread.currentThread().getName());
                    }
                }
                if (!photosToUpload.isEmpty()) {
                    uploadPhotos();
                    log.info("Фото были загружены");
                }
            }
        }
    }

    public void stopAutoUpload() {
        synchronized (lock) {
            isRunning = false;
            lock.notify();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }

    }

    public void uploadPhotos() {
        photosToUpload.forEach(photo -> log.info("фото {} загружено", photo));
        photosToUpload.clear();
    }
}
