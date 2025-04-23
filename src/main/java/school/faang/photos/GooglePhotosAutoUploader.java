package school.faang.photos;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {

    private final Deque<String> photos = new ArrayDeque<>();
    private boolean autoUpdateOn;

    public void startAutoUpload() throws InterruptedException {
        autoUpdateOn = true;
        log.info("starts auto update");
        while (autoUpdateOn) {
            log.info("auto update running");
            uploadPhoto();
        }
    }

    public void uploadPhoto() throws InterruptedException {
        String pathToPhoto;
        synchronized (photos) {
            if (photos.isEmpty()) {
                photos.notify();
                log.info("autoloader waiting new photos");
                photos.wait();
                log.info("continue uploading");
                if (!autoUpdateOn) {
                    return;
                }
            }
            pathToPhoto = photos.pop();
        }
        log.info("uploading {} start", pathToPhoto);
        uploadProcess();
        log.info("uploading {} finished", pathToPhoto);
    }

    public void onNewPhotoAdded(String... photoPath) {
        synchronized (photos) {
            photos.addAll(List.of(photoPath));
            log.info("added {} new photos", photoPath.length);
            photos.notify();
        }
    }

    public void turnOffAutoUpdate() throws InterruptedException {
        synchronized (photos) {
            if (!photos.isEmpty()) {
                photos.wait();
            }
            autoUpdateOn = false;
            photos.notify();
        }
    }

    private void uploadProcess() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            log.info("Thread interrupted!!!");
            Thread.currentThread().interrupt();
        }
    }
}
