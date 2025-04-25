package school.faang.google_photo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private static final int MAX_MILLIS_TO_UPLOAD = 5000;
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("Action is interrupted.");
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("New photo added {}.", photoPath);
            lock.notify();
        }
    }

    @SneakyThrows
    private void uploadPhotos() {
        synchronized (lock) {
            log.info("Starting upload...");
            for (String photo : photosToUpload) {
                log.info("Uploading {}.", photo);
                Thread.sleep(MAX_MILLIS_TO_UPLOAD);
                log.info("Complete!");
            }
            log.info("Upload completed!");
            photosToUpload.clear();
        }
    }
}
