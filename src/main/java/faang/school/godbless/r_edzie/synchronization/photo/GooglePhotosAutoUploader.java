package faang.school.godbless.r_edzie.synchronization.photo;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload(GooglePhoto googlePhoto) throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (this.photosToUpload.isEmpty()) {
                    lock.wait();
                }
                this.uploadPhotos(googlePhoto);
            }
        }
    }

    public void uploadPhotos(GooglePhoto googlePhoto) {
        googlePhoto.getPhotoStorage().add(this.photosToUpload.get(0));
        this.photosToUpload.remove(0);
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            this.getPhotosToUpload().add(photoPath);
            lock.notify();
        }
    }
}
