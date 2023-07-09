package faang.school.godbless.multithreading.google_photo;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    List<String> photosToUpload;
    private final Object lock = new Object();
    private volatile boolean isWorking;

    public GooglePhotosAutoUploader() {
        isWorking = true;
        photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (isWorking) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(photoPath + " added " + Thread.currentThread().getName());
            if (isWorking) {
                lock.notifyAll();
            }
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.println(photo + " uploaded " + Thread.currentThread().getName()));
        photosToUpload.clear();
    }

    public void stopAutoUpload() {
        synchronized (lock) {
            isWorking = false;
            lock.notifyAll();
        }
    }
}
