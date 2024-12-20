package school.faang.google_photosync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                photosToUpload.wait();
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            System.out.println("new photo added " + photoPath);
            photosToUpload.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.println("Uploaded " + photo));
        photosToUpload.removeAll(photosToUpload);
    }
}
