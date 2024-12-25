package school.faang.googlephotosyncbjs49037;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private static final int UPLOAD_DELAY_MS = 1000;

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                System.out.println("There are no new photos. Expectation...");
            }
            try {
                lock.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        uploadPhotos();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Added a new photo: " + photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            List<String> photosToUploadCopy = new ArrayList<>(photosToUpload);
            photosToUploadCopy.forEach(photoPath -> {
                System.out.println("Upload photo: " + photoPath);
                try {
                    Thread.sleep(UPLOAD_DELAY_MS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                photosToUpload.remove(photoPath);
            });
            System.out.println("All photo upload");
        }
    }
}
