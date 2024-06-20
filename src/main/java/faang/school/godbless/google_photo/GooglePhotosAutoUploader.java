package faang.school.godbless.google_photo;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (Thread.currentThread().isAlive()) {
            synchronized (lock) {
                System.out.println("Trying to add photo to Google Cloud");

                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(Thread.currentThread().getName() + " was interrupted");
                    }
                }

                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(photoPath + " was added to photosToUpload");

            lock.notify();
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach((photoPath) -> System.out.println("Photo " + photoPath + " was added to Google Cloud"));
        photosToUpload.clear();
    }
}
