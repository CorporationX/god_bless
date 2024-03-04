package faang.school.godbless.googlephoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public List<String> getPhotosToUpload() {
        return photosToUpload;
    }

    public void startAutoUpload(GooglePhoto googlePhoto) {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos(googlePhoto);
            }
        }
    }

    public void uploadPhotos(GooglePhoto googlePhoto) {
        googlePhoto.getPhotoStorage().add(photosToUpload.get(0));
        photosToUpload.remove(0);
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Photo added: " + photoPath);
            lock.notify();
        }
    }
}
