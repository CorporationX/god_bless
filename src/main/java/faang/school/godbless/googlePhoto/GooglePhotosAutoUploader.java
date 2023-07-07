package faang.school.godbless.googlePhoto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();
    private volatile boolean running = true;

    public void startAutoUpload() {
        while (running) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("No new photos to upload. Waiting for new photos...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.err.println("Error occurred while waiting for new photos: " + e.getMessage());
                    }
                }
            }

            uploadPhotos();
        }
    }

    public void stopAutoUpload() {
        running = false;
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notifyAll();
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            System.out.println("Uploading photos to Google Photos...");
            for (String photoPath : photosToUpload) {
                System.out.println("Uploading: " + photoPath);

            }
            photosToUpload.clear();
        }
    }
}
