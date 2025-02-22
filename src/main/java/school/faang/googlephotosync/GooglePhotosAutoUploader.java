package school.faang.googlephotosync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class GooglePhotosAutoUploader {
    private static final Object LOCK = new Object();
    private static final List<String> PHOTOS_TO_UPLOAD = new ArrayList<>();
    private static final int TIME_EXECUTION = 1000;


    public void startAutoUpload() throws InterruptedException {
        while (true) {
            synchronized (LOCK) {
                while (PHOTOS_TO_UPLOAD.isEmpty()) {
                    LOCK.wait();
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) throws InterruptedException {
        Objects.requireNonNull(photoPath, "Invalid photo path");
        synchronized (LOCK) {
            Thread.sleep(TIME_EXECUTION);
            PHOTOS_TO_UPLOAD.add(photoPath);
            log.info("New photo added: {}", photoPath);
            LOCK.notify();
        }
    }

    private void uploadPhotos() throws InterruptedException {
        synchronized (LOCK) {
            Thread.sleep(TIME_EXECUTION);
            PHOTOS_TO_UPLOAD.forEach(photoPath ->
                    log.info("Photos uploaded to the server on path {}", photoPath));
            PHOTOS_TO_UPLOAD.clear();
        }
    }
}
