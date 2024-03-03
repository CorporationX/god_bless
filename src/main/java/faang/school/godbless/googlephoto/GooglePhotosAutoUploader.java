package faang.school.godbless.googlephoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object LOCK = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public List<String> getPhotosToUpload() {
        return photosToUpload;
    }

    public void startAutoUpload(GooglePhoto googlePhoto) {
        synchronized (LOCK) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        LOCK.wait();
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
        synchronized (LOCK) {
            photosToUpload.add(photoPath);
            System.out.println("Photo added: " + photoPath);
            LOCK.notify();
        }
    }
}
