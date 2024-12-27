package school.faang.task_48912;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    System.out.println("waiting.." + Thread.currentThread().getName());
                    lock.wait(900);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> {
            System.out.println("uploading photo: " + photo + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        photosToUpload.clear();
    }
}