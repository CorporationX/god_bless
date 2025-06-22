package school.faang.bjs2_82007;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    @Getter
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader(@NonNull List<String> photosToUpload) {
        this.photosToUpload = new ArrayList<>(photosToUpload);  // Создаём копию
    }

    public void startAutoUpload(String fileName) {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                log.info("The list for uploading photos is empty");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
                   log.warn("Interrupted while waiting for upload photos to complete");
                }
            }
            uploadPhotos();
            log.info("The list for uploading photos is completed");
        }

    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
            log.info("New photos added is completed");
        }
    }

    public void uploadPhotos() {
        log.info("Uploading photos to Google Photos Auto Uploader");
        photosToUpload.clear();
    }
}
