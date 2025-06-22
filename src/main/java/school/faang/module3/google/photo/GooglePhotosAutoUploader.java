package school.faang.module3.google.photo;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    System.out.println("wait until someone add photo to the queue");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoPath(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("add photo to the queue");
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for (String path : photosToUpload) {
            System.out.printf("photo in path %s uploaded\n", path);
        }
        photosToUpload.clear();
    }
}
