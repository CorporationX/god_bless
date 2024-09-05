package faang.school.godbless.multithreading.synch.googlephoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();

    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {

                while (photosToUpload.isEmpty()) {
                    try {
                        System.out.println("list of photos to upload is empty, waiting...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("Photo upload processing...");
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.clear();
        System.out.println("All photos uploaded");
    }
}
