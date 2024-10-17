package school.faang.googlephoto;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    System.out.println("There are no photos to upload");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    log.error("Caught exception: ", e);
                    throw new IllegalStateException("Thread was interrupted while waiting", e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Photo " + photo + " uploaded to server");
        }
        photosToUpload.clear();
    }
}
