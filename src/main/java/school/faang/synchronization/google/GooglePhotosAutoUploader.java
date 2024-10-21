package school.faang.synchronization.google;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>(List.of("path1", "path2", "path3"));

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Uploading is interrupted");
                }
            } else {
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        System.out.println("Photos have been uploaded");
        photosToUpload.forEach(photo -> System.out.println("Uploading photo : " + photo));
        photosToUpload.clear();
    }
}
