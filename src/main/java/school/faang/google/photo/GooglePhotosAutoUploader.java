package school.faang.google.photo;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static List<String> photosToUpload = new ArrayList<>();

    public synchronized void startAutoUpload() {
        if (photosToUpload.isEmpty()) {
            System.out.println("Upload queue is empty now.\nWaiting for new photos to be added");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        uploadPhotos();
    }

    public synchronized void onNewPhotoAdded(String... photoPath) {
        photosToUpload.addAll(List.of(photoPath));
        System.out.println("Contents of upload queue: " + photosToUpload);
        notify();
    }

    private void uploadPhotos() {
        System.out.println("All photos from queue has been uploaded to the cloud");
        photosToUpload.clear();
    }
}
