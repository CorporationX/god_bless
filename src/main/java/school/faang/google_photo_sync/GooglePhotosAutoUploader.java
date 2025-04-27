package school.faang.google_photo_sync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        while (true) {
            synchronized (lock) {

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.info("Error up load files!");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            uploadPhotos();

        }
    }

    public void uploadPhotos() throws InterruptedException {

        for (String photoPath : new ArrayList<>(photosToUpload)) {
            log.info("Loading photo: {}", photoPath);
            try {
                int sleepTime = 500;
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                log.info("Loading can stop: {}", photoPath);
                Thread.currentThread().interrupt();
                break;
            }

            photosToUpload.clear();
            log.info("Photo load success and remove to list");
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Add new photo: {}", photoPath);
            lock.notify();
        }
    }
}
