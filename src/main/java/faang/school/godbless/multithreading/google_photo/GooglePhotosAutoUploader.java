package faang.school.godbless.multithreading.google_photo;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock;
    private final List<String> photosToUpload;
    private final List<String> googlePhotos;
    private boolean isRunning;

    public GooglePhotosAutoUploader() {
        lock = new Object();
        photosToUpload = new ArrayList<>();
        googlePhotos = new ArrayList<>();
        isRunning = true;
    }

    public void startAutoUpload() {
        while (isRunning) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                } else {
                    uploadPhotos();
                }
            }
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.forEach(photo -> {
                System.out.println(photo + " uploaded with " + Thread.currentThread().getName());
                googlePhotos.add(photo + " processed");
            });
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(photoPath + " was added with " + Thread.currentThread().getName());
            lock.notify();
        }
    }

    public List<String> getGooglePhotos() {
        return googlePhotos;
    }

    public void stop() {
        synchronized (lock) {
            isRunning = false;
            lock.notify();
        }
    }
}
