package school.faang.photo;

import lombok.Getter;
import lombok.Synchronized;

import java.util.ArrayList;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    @Getter
    private final ArrayList<String> photosToUpload = new ArrayList<>();

    @Synchronized("lock")
    public void startAutoUpload() {
        while (true) {
            try {
                while (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                uploadPhotos();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    @Synchronized("lock")
    public void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        System.out.printf("Added a new photo: %s", photoPath);
        System.out.println();
        lock.notify();

    }

    @Synchronized("lock")
    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.printf("Uploading a photo: %s", photo);
            System.out.println();
        }
        photosToUpload.clear();
    }
}
