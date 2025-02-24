package school.faang.BJS2_61837;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.print("GooglePhotosAutoUploader interrupted\n");
                }

            }
            System.out.print("Auto upload started\n");
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.printf("New photo added: %s\n", photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            System.out.printf("Uploading photo: %s\n", photoPath);
        }
        photosToUpload.clear();
    }
}
