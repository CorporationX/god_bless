package ru.kraiush.BJS2_37206;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            uploadPhoto();
        }
    }

    private void uploadPhoto() {
        for (String photo : photosToUpload) {
            System.out.println(photo + " was uploaded to the Google server.");
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(photoPath + " was added to the photo list.");
            lock.notify();
        }
    }
}
