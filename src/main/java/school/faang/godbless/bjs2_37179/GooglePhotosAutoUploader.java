package school.faang.godbless.bjs2_37179;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private static final int UPLOAD_TIME = 1000;

    private List<String> photosToUpload = new ArrayList<>();

    public synchronized void startAutoUpload() {
        try {
            while (photosToUpload.isEmpty()) {
                log.info("Thread {} is waiting for photos to be added", Thread.currentThread().getName());
                wait();
            }
            uploadPhotos();
        } catch (InterruptedException ex) {
            log.warn("Interrupted with exception: {}", String.valueOf(ex));
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        log.info("Added photo {} for uploading ", photoPath);
        notifyAll();
    }

    private void uploadPhotos() throws InterruptedException {
        for (String photo : photosToUpload) {
            log.info("Uploading photo {} ...", photo);
            Thread.sleep(UPLOAD_TIME);
        }
        photosToUpload = new ArrayList<>();
    }
}
