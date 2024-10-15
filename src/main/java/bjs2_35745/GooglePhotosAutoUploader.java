package bjs2_35745;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                System.out.println("No photos to add. Switching to a waiting state");
                lock.wait();
            }
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.clear();
            System.out.println("All the photos were uploaded!");
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
