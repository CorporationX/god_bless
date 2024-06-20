package faang.school.godbless.multithreading_synchronization.task_2;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                    uploadPhotos();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Thread was interrupted while waiting for photos to upload " + e);
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        System.out.println("Uploading photos...");
        photosToUpload.clear();
    }
}
