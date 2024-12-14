package faang.school.godbless.googlephotosync;

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
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            System.out.println("Uploading... " + photoPath);
        }
        photosToUpload.clear();
    }


}
