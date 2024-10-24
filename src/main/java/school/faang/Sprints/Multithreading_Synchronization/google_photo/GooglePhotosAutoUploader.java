package school.faang.Sprints.Multithreading_Synchronization.google_photo;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " come in");
            if (photosToUpload.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " add photo");
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
            System.out.println(Thread.currentThread().getName() + " job");
            photosToUpload.forEach(System.out::println);
            photosToUpload.clear();
    }
}
