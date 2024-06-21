package GooglePhotoSync;


import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final Object lock = new Object();
    private static List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (!photosToUpload.isEmpty()) {
                    uploadPhotos();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void uploadPhotos() {
        while (!photosToUpload.isEmpty()) {
            System.out.println("Upload photo");
            photosToUpload.remove(0);
        }
    }

    public void onNewPhotoAdded(@NonNull String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
