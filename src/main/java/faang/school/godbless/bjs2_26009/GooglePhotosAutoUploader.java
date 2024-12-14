package faang.school.godbless.bjs2_26009;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                log.info("Trying to upload photo");
                if (photosToUpload.isEmpty()) {
                    log.info("Photos to upload list is empty");
                    try {
                        log.info("Waiting while other thread will add new photos");
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted");
                    }
                }
                log.info("Start to upload photo");
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.forEach(s -> log.info("Upload photo to Google Photos from link: {}", s));
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            log.info("Add new photo: {}", photoPath);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
