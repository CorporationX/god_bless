package faang.school.godbless.BJS224574;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            try {
                while (true) {
                    if (photosToUpload.isEmpty()) {
                        log.info("No photos, waiting");
                        lock.wait();
                    }
                    uploadPhotos();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Loading complete");
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            log.info("New photo added, name: " + photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            System.out.println("Perform some logic on presenting photos on the Google Photos server");
            photosToUpload.clear();
            log.info("All photo uploaded");
        }
    }
}
