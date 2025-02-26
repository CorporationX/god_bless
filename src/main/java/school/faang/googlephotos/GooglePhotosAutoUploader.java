package school.faang.googlephotos;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();

    List<String> photosToUpload = Collections.synchronizedList(new ArrayList<>());

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("The thread is interrupted", e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(photo -> {
            log.info("The {} is being uploaded", photo);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        log.info("The photos uploading has ended");
        photosToUpload.clear();
    }
}
