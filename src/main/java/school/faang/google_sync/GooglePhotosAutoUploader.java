package school.faang.google_sync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private Object lock = new Object();

    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Uploading: " + photo);
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Adding: " + photoPath);
            lock.notifyAll();
        }
    }
}
