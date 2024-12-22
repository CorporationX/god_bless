package school.faang.bjs248918;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        try {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                uploadPhotos();
            }
        } catch (InterruptedException e) {
            System.out.println("Error occurred while uploading photos: " + e.getMessage());
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Uploading photo: " + photo);
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notifyAll();
        }
    }
}
