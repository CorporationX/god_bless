package faang.school.godbless.sync.google;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private boolean running = true;

    public void startAutoUpload() {
        synchronized (lock) {
            while (running) {
                while (photosToUpload.isEmpty() && running) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!photosToUpload.isEmpty()) {
                    uploadPhotos();
                }
            }
            System.out.println("Auto-upload stopped.");
        }
    }

    private void uploadPhotos() {
        System.out.println("Started cloud sync...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.photosToUpload.clear();
        System.out.println("Queue: " + this.photosToUpload);
        System.out.println("Finished cloud sync!");
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            this.photosToUpload.add(photoPath);
            System.out.println("Added a photo at " + photoPath);
            lock.notify();
        }
    }

    public void stopAutoUpload() {
        synchronized (lock) {
            running = false;
            lock.notify();
        }
    }
}
