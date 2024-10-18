package dima.evseenko.photo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                System.out.println("No photos to upload, waiting...");
                lock.wait();
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach((s -> System.out.println("Uploading " + s + " to Google Photos!")));
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String... photoUrl) {
        synchronized (lock) {
            System.out.println("New photos added: " + Arrays.toString(photoUrl));
            photosToUpload.addAll(Arrays.asList(photoUrl));
            lock.notify();
        }
    }
}
