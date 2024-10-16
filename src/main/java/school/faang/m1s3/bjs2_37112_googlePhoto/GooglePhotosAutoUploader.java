package school.faang.m1s3.bjs2_37112_googlePhoto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Process was interrupted" + e.getMessage());
                }
            }
            uploadPhotos();
        }
    }

    public void oneNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        System.out.println(LocalTime.now() + " : Photos uploaded: ");
        photosToUpload.forEach(System.out::println);
        photosToUpload.clear();
    }
}
