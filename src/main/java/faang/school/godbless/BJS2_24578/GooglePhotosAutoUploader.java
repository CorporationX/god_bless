package faang.school.godbless.BJS2_24578;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Photo with path " + photoPath + " was added for upload");
            lock.notify();
        }
    }

    public void uploadPhotos() {
        System.out.println("Uploading photos to the Google Photos server");
        photosToUpload.clear();
        System.out.println("Photos were uploaded");
    }
}
