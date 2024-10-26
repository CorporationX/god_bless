package school.faang.BJS2_37479;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                try {
                    while (photosToUpload.isEmpty()) {
                        System.out.println(" No new photo ");
                        lock.wait();
                    }
                    uploadPhotos();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            for (String photo : photosToUpload) {
                System.out.println("Loading photo " + photo);
            }
            photosToUpload.clear();
            System.out.println(" All photos uploaded ");
        }
    }

    public void onNewPhotoAdded(String photoPatch) {
        synchronized (lock) {
            photosToUpload.add(photoPatch);
            System.out.println(" New photo added " + photoPatch);
            lock.notify();
        }
    }
}
