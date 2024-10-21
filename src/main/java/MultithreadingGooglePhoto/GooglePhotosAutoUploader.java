package MultithreadingGooglePhoto;

import java.util.List;

public class GooglePhotosAutoUploader {
    private List<String> photosToUpload;
    private final Object lock = new Object();

    public GooglePhotosAutoUploader(List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
    }

    public void startAutoUpload() throws InterruptedException {
        synchronized(lock) {
            while (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();
            System.out.println("Uploaded recently added photos");
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized(lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            System.out.println("Uploading " + photoPath);
        }
        System.out.println("Added new photos");
        photosToUpload.clear();
    }
}
