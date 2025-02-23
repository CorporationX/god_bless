package googlePhotos;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        log.error("The photo uploading process was interrupted.", e);
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        Objects.requireNonNull(photoPath, "Photo path cannot be null.");
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("New photo added: " + photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Uploading to Google Photos: " + photo);
        }
        photosToUpload.clear();
    }
}
