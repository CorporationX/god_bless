package school.faang.google_photosync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                try {
                    photosToUpload.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread was interrupted: " + e.getMessage());
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            System.out.println("new photo added " + photoPath);
            photosToUpload.notifyAll();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.println("Uploaded " + photo));
        photosToUpload.removeAll(photosToUpload);
    }
}
