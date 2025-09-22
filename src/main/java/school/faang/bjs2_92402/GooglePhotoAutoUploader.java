package school.faang.bjs2_92402;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotoAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                System.out.println("We are waiting");
                lock.wait();
            }
            System.out.println("We'll do it");
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("New photo is added");
            lock.notify();
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.printf("Photo is uploaded %s\n", photo));
        photosToUpload.clear();
    }
}
