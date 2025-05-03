package school.faang.bjs2_73763;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private boolean autoUploadEnabled = false;

    private void uploadPhotos() {
        photosToUpload.forEach(photoPath -> System.out.printf("Uploading %s...%n", photoPath));
        photosToUpload.clear();
    }

    public void startAutoUpload() {
        autoUploadEnabled = true;
        while (autoUploadEnabled) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.printf("Upload thread '%s' interrupted!%n", Thread.currentThread().getName());
                        Thread.currentThread().interrupt();
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void stopAutoUpload() {
        autoUploadEnabled = false;
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notifyAll();
        }
    }
}
