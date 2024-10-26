package school.faang.sprint3.google;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("Wait for photos to be given");
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    uploadPhotos();
                    lock.notify();
                }
            }
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println(photo + " uploaded on Google server");
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(List<String> newPhotos) {
        synchronized (lock) {
            photosToUpload.addAll(newPhotos);
            System.out.println("New photos are added");
            lock.notify();
        }
    }
}
