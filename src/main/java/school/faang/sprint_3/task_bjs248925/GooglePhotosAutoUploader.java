package school.faang.sprint_3.task_bjs248925;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j

@AllArgsConstructor
public class GooglePhotosAutoUploader {
    private static final int MILLIS_SLEEP_BEFORE_NEW_PHOTO = 890;
    private final List<String> photosToUpload;

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                try {
                    log.info("{} is waiting...", Thread.currentThread().getName());
                    photosToUpload.wait();
                } catch (InterruptedException e) {
                    log.warn("{} was interrupted", Thread.currentThread().getName());
                    Thread.currentThread().interrupt();
                }
            }
            upload();
        }
    }

    private void upload() {
        photosToUpload.forEach(photo -> log.info("{} is uploading photo {}", Thread.currentThread().getName(), photo));
        photosToUpload.clear();
    }

    public void addNewPhoto(String path) {
        synchronized (photosToUpload) {
            photosToUpload.add(path);
            photosToUpload.notify();
            log.info("{} added new photo {}", Thread.currentThread().getName(), path);
        }
        try {
            Thread.sleep(MILLIS_SLEEP_BEFORE_NEW_PHOTO);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
