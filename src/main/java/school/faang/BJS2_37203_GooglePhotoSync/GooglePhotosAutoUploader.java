package school.faang.BJS2_37203_GooglePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private List<String> photosToUpload;
    private Object lock;

    public GooglePhotosAutoUploader() {
        photosToUpload = new ArrayList<>();
        lock = new Object();
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                System.out.println("There are no photos to upload. Waiting for new one...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new IllegalStateException("Upload thread was interrupted.", e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        System.out.println("Uploading photos...");
        photosToUpload.forEach(photoPath -> System.out.printf("Photo %s was uploaded.\n", photoPath));
        photosToUpload.clear();
    }
}
