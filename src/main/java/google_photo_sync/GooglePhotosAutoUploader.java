package google_photo_sync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();
    private List<String> uploadedPhotos = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    uploadPhotos();
                }
            }
        }
    }

    private void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            System.out.println("Uploading photo " + photoPath);
            uploadedPhotos.add(photoPath);
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public List<String> getUploadedPhotos() {
        synchronized (lock) {
            return new ArrayList<>(uploadedPhotos);
        }
    }
}
