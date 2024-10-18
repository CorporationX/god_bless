package school.faang.googlephotosyng;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    @Getter
    private List<String> photosToUpload;

    public GooglePhotosAutoUploader(List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
    }

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.println("Adding new photo: " + photoPath);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        System.out.println("Uploading photos...");
        photosToUpload = new ArrayList<>();
    }
}
