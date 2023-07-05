package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task4;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final Object lock = new Object();

    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("No photos to upload");
                    try {
                        System.out.println("Waited");
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
            System.out.println("Uploading photo " + photoPath);
            lock.notifyAll();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.forEach(photo -> System.out.println("Uploading photo " + photo));
            photosToUpload.clear();
        }
    }
}
