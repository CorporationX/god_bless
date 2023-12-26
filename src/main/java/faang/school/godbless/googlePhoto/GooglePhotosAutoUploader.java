package faang.school.godbless.googlePhoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private Object lock;
    private List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        this.lock = new Object();
        this.photosToUpload = new ArrayList<>();
    }

    void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos(photosToUpload);
        }
    }

    void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    void uploadPhotos(List<String> photosToUpload) {
        photosToUpload.forEach(s -> System.out.println(s + " - was uploaded"));
        photosToUpload.clear();
    }
}
