package faang.school.godbless.synchronize.googlePhotos;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private  List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("Waiting for photos to upload...");
                    lock.wait();
                } else {
                    uploadPhotos();
                    break;
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + ": Adding: " + photoPath);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() throws InterruptedException {
        synchronized (lock) {
            for (String s : photosToUpload) {
                System.out.println(Thread.currentThread().getName() + ": Uploading: " + s);
                lock.wait(1000);
                System.out.println("Done uploading: " + s);
            }
            photosToUpload.clear();
        }
    }
}
