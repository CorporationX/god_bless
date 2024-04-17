package faang.school.godbless.synchronization.googlePhotos;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();  //paths to files

    public void startAutoUpload() {
        while(true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        log.warn("Waiting new photos was interrupted.");
                        return;
                    }
                }

                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photoPath -> log.info("Photo (" + photoPath + ") was uploaded."));

        photosToUpload = new ArrayList<>();
    }

    public void onNewPhotoAdded(String photoPath) {
        if(photoPath == null || photoPath.isBlank()) {
            log.info("Attempt to add empty photo path failed.");

            return;
        }

        synchronized (lock) {
            photosToUpload.add(photoPath);

            log.info("Added new photo path (" + photoPath + ")");

            lock.notify();
        }
    }

}
