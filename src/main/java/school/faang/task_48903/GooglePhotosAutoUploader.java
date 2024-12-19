package school.faang.task_48903;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

@Slf4j
public class GooglePhotosAutoUploader {
    private static final int UPLOAD_DELAY = 2000;

    private final Queue<String> photosToUpload = new ArrayDeque<>();

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                try {
                    photosToUpload.wait();
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        String photoPath = photosToUpload.element();
        log.info("{} uploads the image {} to the server...", Thread.currentThread().getName(), photoPath);
        try {
            Thread.sleep(UPLOAD_DELAY);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        photosToUpload.remove(photoPath);
        log.info("{} has completed uploading the image {} to the server", Thread.currentThread().getName(), photoPath);
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
            log.info("{} added a photo {}", Thread.currentThread().getName(), photoPath);
        }
    }
}
