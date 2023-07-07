package faang.school.godbless.googlePhoto;


import lombok.SneakyThrows;

import java.util.Collections;
import java.util.List;

public class GooglePhotosAutoUploader {
    private Object lock = new Object();

    private List<String> photosToUpload = Collections.emptyList();

    @SneakyThrows
    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("Waiting for upload...");
                    lock.wait();
                }
                uploadPhotos(photosToUpload);
            }
        }
    }

    public void uploadPhotos(List<String> photosToUpload) {
        synchronized (lock) {
            System.out.println("Uploading...");
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Photo added!");
            lock.notify();
        }
    }
}
