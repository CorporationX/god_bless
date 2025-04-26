package school.faang.google_photo_sync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.info("Error up load files!");
                }
            }
            uploadPhotos();
        }
    }

    public void uploadPhotos() throws InterruptedException {

        synchronized (lock) {

            for (String photoPath : new ArrayList<>(photosToUpload)) {

                log.info("Loading photo: {}", photoPath);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    log.info("Loading can stop: {}", photoPath);
                }

                photosToUpload.remove(photoPath);
                log.info("Photo {} load success and remove to list", photoPath);
            }
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
