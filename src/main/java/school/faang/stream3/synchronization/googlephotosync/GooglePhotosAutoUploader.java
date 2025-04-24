package school.faang.stream3.synchronization.googlephotosync;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GooglePhotosAutoUploader {
    List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (!photosToUpload.isEmpty()) {
                    uploadPhotos();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    public void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.printf("%s is uploaded\n", photo);
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            try {
                int waitingTime = new Random().nextInt(500, 3000);
                Thread.sleep(waitingTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            lock.notify();
        }
    }
}
