package faang.school.godbless.BJS2_24482;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                try {
                    if (!photosToUpload.isEmpty()) {
                        uploadPhotos();
                    } else {
                        lock.wait();
                        System.out.println("I'm waiting for photos to upload");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.forEach(photo -> System.out.println("Uploading photo: " + photo));
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
