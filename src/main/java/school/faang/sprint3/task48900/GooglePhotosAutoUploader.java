package school.faang.sprint3.task48900;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (!photosToUpload.isEmpty()) {
                uploadPhotos();
            } else {
                lock.wait();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("Photo " + photoPath + " was added");
            lock.notify();
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            for (String s : photosToUpload) {
                log.info("Photo " + s + " uploaded to server");
            }
            photosToUpload.clear();
            lock.notify();
        }
    }

}
