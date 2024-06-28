package faang.school.godbless.multithreading.synchronization.googlePhoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("Waiting new photo...");
                        photosToUpload.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Thread was interrupted");
                    }
                }
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        System.out.println("Uploading photos...");
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }
    }
}
