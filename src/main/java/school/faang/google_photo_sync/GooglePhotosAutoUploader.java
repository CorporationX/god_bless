package school.faang.google_photo_sync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("New photo added to the " + photoPath);
            lock.notify();
        }
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            uploadPhotos();
            System.out.println("Upload to server");
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            System.out.println("Uploaded to the server");
            photosToUpload.clear();
        }
    }
}
