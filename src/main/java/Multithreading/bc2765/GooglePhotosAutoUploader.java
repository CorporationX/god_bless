package Multithreading.bc2765;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();

    final List<String> photosToUpload = new ArrayList<>();
    List<String> photos = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (!photosToUpload.isEmpty()) {
                uploadPhotos();
            } else {
                System.out.println("I'm here");
                lock.wait(2000);
            }
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            photos.addAll(photosToUpload);
            photosToUpload.clear();
            for (String str : photos) {
                System.out.println(str);
            }
        }
    }

    public void oneNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
