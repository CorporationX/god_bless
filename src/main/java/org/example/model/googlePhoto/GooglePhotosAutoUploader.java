package org.example.model.googlePhoto;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                System.out.println("thread waiting new photos!");
                lock.wait();
            }
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        System.out.println("upload new photos to google photo!");
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("new photo added!");
            lock.notify();
        }
    }
}
