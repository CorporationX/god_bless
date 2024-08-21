package BJS2_24401_GooglePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    public void startAutoUpload() {
        synchronized (lock) {
            try {
                while (true) {
                    if (photosToUpload.isEmpty()) {
                        System.out.println("Nothing to upload!");
                        lock.wait();
                    }
                    System.out.println("____Initiating to upload..._____");
                    uploadPhotos();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Added new photo! " + photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            System.out.println("____Uploading photo to Google server...____");
            photosToUpload.clear();
        }
    }
}
