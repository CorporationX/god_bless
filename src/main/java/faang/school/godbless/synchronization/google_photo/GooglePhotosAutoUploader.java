package faang.school.godbless.synchronization.google_photo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private Queue<String> photosToUpload = new ArrayDeque<>();
    private boolean AUTO_UPLOAD = true;

    public void startAutoUpload() {
        while (AUTO_UPLOAD) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("GooglePhotosAutoUploader interrupted");
                    }
                }
                while (!photosToUpload.isEmpty()) {
                    uploadPhotos();
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        if (photoPath.isBlank() || photoPath.equals(null)) {
            throw new IllegalArgumentException("photoPath is null or empty");
        }
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        if (!photosToUpload.isEmpty()) {
            System.out.println("Uploading photo: " + photosToUpload.poll());
        }
    }

    public void offAutoUpload() {
        synchronized (lock){
            this.AUTO_UPLOAD = false;
            lock.notify();
        }
    }
}
