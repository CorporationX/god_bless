package faang.school.godbless.googlephotosync2971;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object LOCK = new Object();
    private List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        this.photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload(GooglePhoto googlePhoto) throws InterruptedException {
        while (true) {
            synchronized (this.LOCK) {
                if (this.photosToUpload.isEmpty()) {
                    LOCK.wait();
                }
                this.uploadPhotos(googlePhoto);
            }
        }
    }

    private void uploadPhotos(GooglePhoto googlePhoto) {
        googlePhoto.getPhotosStorage().add(this.photosToUpload.get(0));
        this.photosToUpload.remove(0);
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (this.LOCK) {
            this.photosToUpload.add(photoPath);
            LOCK.notify();
        }
    }
}
