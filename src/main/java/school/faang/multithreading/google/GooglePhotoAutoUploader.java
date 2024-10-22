package school.faang.multithreading.google;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotoAutoUploader {

    private final List<String> photosToUpload;

    public GooglePhotoAutoUploader() {
        photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            if (!photosToUpload.isEmpty()) {
                uploadPhotos();
            } else {
                try {
                    photosToUpload.wait();
                } catch (InterruptedException err) {
                    throw new IllegalStateException("Поток прерван до или во время выполнения действия", err);
                }
            }
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.println("Photo uploaded " + photo));
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            if (photoPath != null && !photoPath.isEmpty()) {
                photosToUpload.add(photoPath);
                photosToUpload.notify();
            } else {
                throw new IllegalArgumentException("Path to photo is empty");
            }
        }
    }
}
