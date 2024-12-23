package school.faang.task_48892;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(String.format("Upload photo %s thread %s. Number of uploaded photo's %d", photoPath,
                    Thread.currentThread().getName(), photosToUpload.size()));
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.forEach((photo) -> System.out.println(String
                    .format("Photo upload %s on server thread %s", photo, Thread.currentThread().getName())));
            System.out.println("All photo uploaded.");
            photosToUpload.clear();
        }
    }
}
