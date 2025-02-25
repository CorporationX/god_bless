package school.faang;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final Object lock = new Object();
    private static final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Interrupted while waiting for auto upload", e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(@NonNull String photo) {
        synchronized (lock) {
            photosToUpload.add(photo);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.printf("Photo: %s is uploaded\n", photo);
        }
        photosToUpload.clear();
    }
}
