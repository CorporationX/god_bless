package faang.school.godbless.googlephoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final List<String> PHOTOS_TO_UPLOAD = new ArrayList<>();
    private final Object LOCK = new Object();

    public void startAutoUpload() {
        while (true) {
            synchronized (LOCK) {
                if (PHOTOS_TO_UPLOAD.isEmpty()) {
                    wait(LOCK);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (LOCK) {
            PHOTOS_TO_UPLOAD.add(photoPath);
            LOCK.notify();
        }
        System.out.println("Photo added");
    }

    private void uploadPhotos() {
        System.out.println("Uploading photo...");
        sleep(3L);
        System.out.println("Uploaded");
        PHOTOS_TO_UPLOAD.clear();
    }

    private void wait(Object lock) {
        try {
            lock.wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void sleep(Long seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
