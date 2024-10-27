package faang.school.godbless.google_photo_sync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized(lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        System.out.printf("Thread '%s': Waiting for new photos to be added...%n", Thread.currentThread().getName());
                        lock.wait(4000);
                        if (photosToUpload.isEmpty()) {
                            Thread.currentThread().interrupt();
                        }
                    } catch(InterruptedException e) {
                        System.out.println("Timeout reached, termination execution...");
                        break;
                    }
                    uploadPhotos();
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.printf("Thread '%s': Adding photo - %s%n", Thread.currentThread().getName(), photoPath);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(p -> System.out.printf("Thread '%s': Uploading photo - %s%n", Thread.currentThread().getName(), p));
        photosToUpload.clear();
    }
}
