package faang.school.godbless.multithreading.synchronization.googlePhoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("Waiting new photo...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Thread was interrupted");
                    }
                }
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        System.out.println("Uploading photos...");
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
