package school.faang.synchphoto;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                lock.wait();
            }
            photosToUpload();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("{} !!!!!! Photo added !!!!!!", photoPath);
            lock.notify();
        }
    }

    private void photosToUpload() {
        photosToUpload.forEach(
                photo -> log.info("{} !!!!!! Photo loaded !!!!!!", photo)
        );
        photosToUpload.clear();
    }
}
