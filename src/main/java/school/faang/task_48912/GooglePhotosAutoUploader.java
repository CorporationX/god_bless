package school.faang.task_48912;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GooglePhotosAutoUploader {
    private volatile boolean isEnded;
    private final Object lock = new Object();
    private final List<String> photosToUpload = new CopyOnWriteArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (!isEnded) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            isEnded = true;
            lock.notify();
            startAutoUpload();
        }
    }

    public void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("uploading photo " + photo);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        photosToUpload.clear();
    }
}