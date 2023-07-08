package faang.school.godbless.multithreading.synchronized_wait_notify.google_photo_sync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();
    private boolean isUploading;

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
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
            lock.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> {
            System.out.println("uploading...");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(photo + " is uploaded to server.");
        });
//        System.out.println("Your photos is uploaded to server.");
        photosToUpload.clear();
    }

    public void initialize() {
        photosToUpload.add("Path123");
        photosToUpload.add("Path32");
        photosToUpload.add("Path1234");
        photosToUpload.add("Path12124");
    }
}
