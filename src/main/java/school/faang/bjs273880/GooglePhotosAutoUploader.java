package school.faang.bjs273880;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private volatile boolean running = true;

    public void startAutoUpload() {
        while (running) {
            synchronized (lock) {
                try {
                    while (photosToUpload.isEmpty() && running) {
                        System.out.printf("Waiting for new photo to upload by %s%n",
                                Thread.currentThread().getName());
                        lock.wait();
                    }
                    uploadPhotos();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.printf("New photo added: %s by %s%n", photoPath, Thread.currentThread().getName());
            lock.notifyAll();
        }
    }

    public void uploadPhotos() {
        photosToUpload.removeIf(photo -> {
            System.out.printf("%s uploaded by %s%n", photo, Thread.currentThread().getName());
            return true;
        });
    }

    public void stop() {
        synchronized (lock) {
            running = false;
            lock.notifyAll();
        }
    }
}
