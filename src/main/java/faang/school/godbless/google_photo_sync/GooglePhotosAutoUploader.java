package faang.school.godbless.google_photo_sync;

import java.util.ArrayDeque;
import java.util.Queue;

public class GooglePhotosAutoUploader {
    private final Object lock;
    private final Queue<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        this.lock = new Object();
        this.photosToUpload = new ArrayDeque<>();
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                }

                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        System.out.printf("File with path '%s' was upload.\n", photosToUpload.poll());
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.println("Add a new photo.");
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}