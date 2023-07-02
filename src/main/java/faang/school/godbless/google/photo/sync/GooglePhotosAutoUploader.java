package faang.school.godbless.google.photo.sync;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                lock.wait();
            }
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            try {
                Thread.sleep(3000);
                System.out.println("photos are uploading");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            photosToUpload = new ArrayList<>();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
