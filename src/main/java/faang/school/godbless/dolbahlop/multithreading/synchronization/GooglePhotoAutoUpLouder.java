package faang.school.godbless.dolbahlop.multithreading.synchronization;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotoAutoUpLouder {
    Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

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

    public void uploadPhotos() {
        System.out.println("Uploading photos to the Google Photos server");
        photosToUpload.clear();
        System.out.println("Photos were uploaded");
    }

    public void oneNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Photo with path " + photoPath + " is ready for upload");
            lock.notify();
        }
    }
}
