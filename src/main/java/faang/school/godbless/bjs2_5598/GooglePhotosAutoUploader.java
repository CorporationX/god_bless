package faang.school.godbless.bjs2_5598;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (!Thread.interrupted()) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("List is empty. Waiting...");
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
            System.out.println("\nAdd new photo to upload: " + photoPath);
            photosToUpload.add(photoPath);
            lock.notify();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void uploadPhotos() {
        System.out.println("\nUpload photos...");
        photosToUpload.forEach(photo -> System.out.println(photo + " was uploaded"));
        System.out.println("All photos uploaded to server");
        photosToUpload.clear();
    }
}
