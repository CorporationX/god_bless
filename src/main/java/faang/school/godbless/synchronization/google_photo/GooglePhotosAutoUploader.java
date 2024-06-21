package faang.school.godbless.synchronization.google_photo;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                        uploadPhotos();
                    } catch (InterruptedException e) {
                        System.out.println("GooglePhotosAutoUploader interrupted");
                    }
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
        System.out.println("Uploading photos...");
        synchronized (lock){
            for (String path : photosToUpload) {
                photosToUpload.remove(path);
                System.out.println("Uploading photo: " + path);
            }
        }
    }
}
