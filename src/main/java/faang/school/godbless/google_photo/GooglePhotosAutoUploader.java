package faang.school.godbless.google_photo;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader implements Runnable {
    public final Object lock = new Object();
    public final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void oneNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        System.out.println("Photo Uploading...");
        for (String photoPath : photosToUpload) {
            System.out.println("Uploading..." + photoPath);
        }
        photosToUpload.clear();
    }

    @Override
    public void run() {
        startAutoUpload();
    }
}
