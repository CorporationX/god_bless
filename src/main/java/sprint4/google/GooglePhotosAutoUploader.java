package sprint4.google;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private boolean autoUploaderWork;

    public void startAutoUpload() {
        synchronized (lock) {
            autoUploaderWork = true;
            while (autoUploaderWork) {
                uploadPhotosIfAvailableOtherwiseWait();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            if (autoUploaderWork) {
                lock.notify();
            }
        }
    }

    public void onNewPhotosAdded(List<String> photosPath) {
        synchronized (lock) {
            photosToUpload.addAll(photosPath);
            if (autoUploaderWork) {
                lock.notify();
            }
        }
    }

    public void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            System.out.printf("Photo from the path: %s was upload to google photos\n", photoPath);
        }
        photosToUpload.clear();
    }

    public void disableUploader() {
        autoUploaderWork = false;
    }

    private void uploadPhotosIfAvailableOtherwiseWait() {
        if (photosToUpload.isEmpty()) {
            try {
                lock.wait(1000);
            } catch (InterruptedException e) {
                System.out.println("Work interrupted");
            }
        } else {
            uploadPhotos();
        }
    }
}
