package school.faang.google_photo_sync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " is waiting for new photos...");
                while (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                System.out.println(Thread.currentThread().getName()
                        + " started uploading " + photosToUpload.size() + " photos");
                uploadPhotos();
                System.out.println(Thread.currentThread().getName() + " cleared queue and returns to waiting\n");
            }
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("[" + Thread.currentThread().getName() + "] Successfully uploaded: " + photo);
        }
        photosToUpload.clear();
    }

    public void onNewPhotosAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("[" + Thread.currentThread().getName() + "] Added to queue: " + photoPath);
            lock.notify();
        }
    }
}
