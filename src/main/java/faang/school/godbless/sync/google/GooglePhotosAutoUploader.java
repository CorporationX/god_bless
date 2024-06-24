package faang.school.godbless.sync.google;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final List<String> photosToUpload = new ArrayList<>();
    private boolean running = true;

    public synchronized void startAutoUpload() {
        while (running) {
            while (photosToUpload.isEmpty() && running) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!photosToUpload.isEmpty()) {
                uploadPhotos();
            }
        }
    }

    private synchronized void uploadPhotos() {
        System.out.println("Started cloud sync...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        photosToUpload.clear();
        System.out.println("Queue: " + this.photosToUpload);
        System.out.println("Finished cloud sync!");
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        this.photosToUpload.add(photoPath);
        System.out.println("Added a photo at " + photoPath);
        notify();
    }

    public synchronized void stopAutoUpload() {
        running = false;
        System.out.println("Auto-upload stopped.");
        notify();
    }
}
