package school.faang.bjs_48984;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private static final int WAIT_TIME = 500;

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private boolean isStarted = false;


    public List<String> startAutoUpload() {
        isStarted = true;
        List<String> uploadedPhotos = new ArrayList<>();

        while (isStarted) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait(WAIT_TIME);
//                        isStarted = false;
                    } catch (InterruptedException e) {
                        log.error("Thread was interrupted", e);
                    }
                }
                uploadedPhotos.addAll(uploadPhotos());
            }
        }
        return uploadedPhotos;
    }

    public void stopAutoUpload() {
        isStarted = false;
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
            log.info("New photo added: {}", photoPath);
        }
    }

    public List<String> uploadPhotos() {
        synchronized (lock) {
            List<String> newPhotos = new ArrayList<>();
            photosToUpload.forEach(photoPath -> {
                newPhotos.add(photoPath);
                log.info("Uploading photo: {}", photoPath);
            });
            photosToUpload.removeAll(newPhotos);

            return newPhotos;
        }
    }
}
