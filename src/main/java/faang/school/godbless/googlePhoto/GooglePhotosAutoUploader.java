package faang.school.godbless.googlePhoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final Object lock = new Object();
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

    public void uploadPhotos() {
        System.out.println("Uploading photos.");
        try {
            Thread.sleep(5000);
            photosToUpload.clear();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.println("Adding new photos");
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
