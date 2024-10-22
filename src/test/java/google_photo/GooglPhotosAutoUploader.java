package google_photo;

import java.util.ArrayList;
import java.util.List;

public class GooglPhotosAutoUploader {
    private Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("No new photos");
                }
            }
            uploadPhoto();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhoto() {
        for (String photo : photosToUpload) {
            System.out.println("Photo upload to server " + photo);
        }
        photosToUpload.clear();
    }
}
