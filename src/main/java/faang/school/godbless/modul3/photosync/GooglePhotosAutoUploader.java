package faang.school.godbless.modul3.photosync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
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

    private void uploadPhotos() {
        photosToUpload.forEach(
                photoPath -> System.out.println("Photo " + photoPath + " was uploaded.")
        );

        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);

            System.out.println("Upload new photo " + photoPath);

            lock.notify();
        }
    }
}
