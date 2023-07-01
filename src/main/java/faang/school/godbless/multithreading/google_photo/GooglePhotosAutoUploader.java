package faang.school.godbless.multithreading.google_photo;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    List<String> photosToUpload;
    private final Object lock = new Object();
    private boolean isWork;

    public GooglePhotosAutoUploader() {
        isWork = true;
        photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (isWork) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    uploadPhotos();
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(photoPath + " added " + Thread.currentThread().getName());
            if (isWork) {
                lock.notify();
            }
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.println(photo + " uploaded " + Thread.currentThread().getName()));
        photosToUpload.clear();
    }

    public void stopAutoUpload() {
        synchronized (lock) {
            isWork = false;
            lock.notify();
        }
    }
}
