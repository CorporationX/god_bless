package school.faang.googlephotosync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            try {
                while (photosToUpload.isEmpty()) {
                    lock.wait();
                    System.out.println("waiting new photo...");
                }
                System.out.println("Photo uploading:");
                uploadPhotos();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            for (String photo : photosToUpload) {
                System.out.println("Uploading new photo: - " + photo);
            }
            photosToUpload.clear();
            System.out.println("Photos are uploaded!!!");
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Added new photo: " + photoPath);
            lock.notify();
        }
    }
}
