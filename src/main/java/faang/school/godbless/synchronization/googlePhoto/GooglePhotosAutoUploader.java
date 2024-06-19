package faang.school.godbless.synchronization.googlePhoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        System.out.println("Start auto upload");
        while (Thread.currentThread().isAlive()) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("No photos to upload. Waiting...");
                        lock.wait();
                        uploadPhotos();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(pathToPhoto -> System.out.println("Photo uploaded: " + pathToPhoto));
        photosToUpload.clear();
    }


    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Photo added. Path: " + photoPath);
            lock.notify();
        }
    }

}
