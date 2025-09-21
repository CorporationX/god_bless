package school.faang.googlephoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            for (String path : photosToUpload) {
                System.out.println("Uploading photo: " + path);
            }
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notifyAll();
        }
    }
}

