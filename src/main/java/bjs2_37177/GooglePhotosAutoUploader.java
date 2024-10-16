package bjs2_37177;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock;
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader(List<String> photoPaths) {
        this.lock = new Object();
        this.photosToUpload = new ArrayList<>(photoPaths);
    }

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();
        }
    }

    public void uploadPhotos() throws InterruptedException {
        photosToUpload.forEach(photo -> System.out.println("Photo " + photo + " was uploaded"));
        photosToUpload.clear();
        startAutoUpload();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
