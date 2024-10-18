package school.faang.google_photo_sync_BJS2_37101;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final String lock = "lock";
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": is waiting");
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
            System.out.println(Thread.currentThread().getName() + ": added " + photoPath);
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(s -> System.out.println(s + " has been uploaded"));
        photosToUpload.clear();
    }
}
