package google.photo.sync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("The list to upload is empty!");
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.err.println("InterruptedException: " + e);
                    }
                }

                System.out.println("Uploading starts...");
                uploadPhotos(photosToUpload);
                photosToUpload.clear();
            }
        }
    }

    private void uploadPhotos(List<String> photosToUpload) {
        for (String photo : photosToUpload) {
            System.out.println("Uploading: " + photo);
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Photo added: " + photoPath);
            lock.notify();
        }
    }
}
