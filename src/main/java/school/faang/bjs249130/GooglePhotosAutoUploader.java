package school.faang.bjs249130;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload;
    private final Object lock = new Object();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    log.info("photosToUpload is Empty, waiting new photos to upload...");
                    lock.wait();
                    log.info("New photos received");
                } catch (InterruptedException e) {
                    log.error(e.getLocalizedMessage());
                }
            }

            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            log.info("New photo: {}", photoPath);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        log.info("Uploading {} photos", photosToUpload.size());
        photosToUpload.clear();
        log.info("Photos Uploaded");
    }
}
