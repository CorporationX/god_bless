package faang.school.godbless.googlePhoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while(true) {
        synchronized (lock) {
            try {
            if(photosToUpload.isEmpty()) {
                System.out.println("No new photos. Waiting for new photos...");
                lock.wait();
            }
            uploadPhotos();
        } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Uploader thread interrupted");
            }
        }
    }
}

public void onNewPhotoAdded(String photoPath) {
        synchronized(lock) {
            photosToUpload.add(photoPath);
            System.out.println("New photo added: " + photoPath);
            lock.notify();
        }
}

    private void uploadPhotos() {
        synchronized (lock) {
            while (!photosToUpload.isEmpty()) {
                String photo = photosToUpload.remove(0);
                System.out.println("Uploading photo: " + photo);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Upload interrupted");
                }
                System.out.println("Photo uploaded: " + photo);
            }
        }
    }
}
