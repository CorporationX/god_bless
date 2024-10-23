package faang.school.godbless.mt.google;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                log.info("Start waiting");
                lock.wait();
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            log.info("Add new photo");
            photosToUpload.add(photoPath);
            lock.notifyAll();
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            if (!photosToUpload.isEmpty()) {
                log.info("Photos uploaded");
                photosToUpload.clear();
            }
        }
    }
}
