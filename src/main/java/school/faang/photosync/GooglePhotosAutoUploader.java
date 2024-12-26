package school.faang.photosync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    System.out.println("Waiting for new photos...");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread was interrupted: " + e.getMessage());
                }
            }
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            System.out.println(String.format("%s - uploading photos : %s", Thread.currentThread().getName(),
                    photosToUpload.toString()));
            photosToUpload.clear();
            System.out.println("All photos uploaded.");
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            this.photosToUpload.add(photoPath);
            System.out.println("New photo added: " + photoPath);
            lock.notify();
        }
    }
}
